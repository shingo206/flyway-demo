package com.example.flywaydemo.controller;

import com.example.flywaydemo.dto.OrderRequest;
import com.example.flywaydemo.dto.OrderResponse;
import com.example.flywaydemo.model.Comment;
import com.example.flywaydemo.model.Customer;
import com.example.flywaydemo.model.Post;
import com.example.flywaydemo.repository.CustomerRepository;
import com.example.flywaydemo.repository.PostRepository;
import com.example.flywaydemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final PostRepository postRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request) {
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders() {
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation() {
        return customerRepository.getJoinInformation();
    }

    @GetMapping("/comments")
    public Post addPostComments() {
        Post post = new Post("Title", "Description");
        post.getComments().add(new Comment("text 1"));
        post.getComments().add(new Comment("text 2"));
        post.getComments().add(new Comment("text 3"));
        postRepository.save(post);
        return post;
    }
}
