package com.btrco.jba.service;

import com.btrco.jba.entity.Blog;
import com.btrco.jba.entity.Item;
import com.btrco.jba.entity.Role;
import com.btrco.jba.entity.User;
import com.btrco.jba.repository.BlogRepository;
import com.btrco.jba.repository.ItemRepository;
import com.btrco.jba.repository.RoleRepository;
import com.btrco.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class InitDBService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init(){
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        User userAdmin = new User();
        userAdmin.setName("admin");
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleUser);
        roles.add(roleAdmin);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);

        Blog blog = new Blog();
        blog.setName("BTRCO");
        blog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blog.setUser(userAdmin);
        blogRepository.save(blog);

        Item item1 = new Item();
        item1.setBlog(blog);
        item1.setTitle("first");
        item1.setLink("http://www.javavids.com");
        item1.setPublishedDate(new Date());
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setBlog(blog);
        item2.setTitle("second");
        item2.setLink("http://www.vk.com");
        item2.setPublishedDate(new Date());
        itemRepository.save(item2);

    }
}
