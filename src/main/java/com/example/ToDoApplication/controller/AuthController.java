package com.example.ToDoApplication.controller;

import com.example.ToDoApplication.Service.ProductService;
import com.example.ToDoApplication.Service.ProjectService;
import com.example.ToDoApplication.dto.ProductCategoryDTO;
import com.example.ToDoApplication.dto.ProductDTO;
import com.example.ToDoApplication.dto.ProjectDto;
import com.example.ToDoApplication.exception.BadRequestException;
import com.example.ToDoApplication.model.*;
import com.example.ToDoApplication.payload.ApiResponse;
import com.example.ToDoApplication.payload.AuthResponse;
import com.example.ToDoApplication.payload.LoginRequest;
import com.example.ToDoApplication.payload.SignUpRequest;
import com.example.ToDoApplication.repository.UserRepository;
import com.example.ToDoApplication.security.TokenProvider;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProductService productService;
    @Autowired
    Gson gson;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        // Creating user's account
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setProvider(AuthProvider.local);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }

    @ResponseBody
    @PostMapping("/addProducts")
    public ResponseEntity<?>addProducts(@Valid @RequestBody ProductCategoryDTO productCategoryDTO){
        productService.save(productCategoryDTO);
        String msg ="Data saved successfully.";
        Gson gson = new Gson();
        String jsonMsg = gson.toJson(msg);
        return new ResponseEntity<>(jsonMsg,new HttpHeaders(),HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/getProducts")
    public  List<ProductCategoryDTO>getAllProduct()
    {
        List<ProductCategoryDTO> productCategoryDTOS=productService.findAll();
        /*for(int i =0;i<=productCategoryDTOS.size();i++){
            List<ProductDTO> productDTOS=productService.findProductByCategoryId(productCategoryDTOS.get(i).getUniqueId());
                   productCategoryDTOS.get(i).setProductList(productDTOS);
        }*/
        return productCategoryDTOS;
    }

    @ResponseBody
    @PostMapping("/addTodo")
    public ResponseEntity<?> addTodo(@Valid @RequestBody Project project){
        projectService.save(project);
        String msg ="Data Saved Successfully.";
        Gson gson = new Gson();
        String jsonMsg= gson.toJson(msg);
        return new ResponseEntity<>(jsonMsg,new HttpHeaders(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/viewTodo")
    public List<ProjectDto> viewTodo(){
        return projectService.findAllProject();
    }

    @ResponseBody
    @PostMapping("/getProdDetails")
    public List<Product>viewProduct(@RequestBody ProductDTO productDTO){
        List<Product> products=productService.findProductById(productDTO.getUniqueId());
        return products;

    }
}
