package edu.cheechyo.wikitriple.controller;

import edu.cheechyo.wikitriple.model.Document;
import edu.cheechyo.wikitriple.model.User;
import edu.cheechyo.wikitriple.repository.DocumentRepository;
import edu.cheechyo.wikitriple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Cheechyo on 2017. 6. 9..
 */
@Controller
public class DocumentController {
    private String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ultrices at urna at tempus. Nulla facilisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris ut mi quis diam semper aliquet eu et nisi. Curabitur nulla sapien, pellentesque ornare dolor id, elementum aliquet neque. Praesent eget tempor erat. Etiam blandit eu erat ac elementum.\n" +
            "\n" +
            "Vivamus felis felis, viverra in justo eget, rutrum finibus dui. In at dapibus purus, vel cursus mauris. Fusce eget ipsum interdum, lacinia libero eu, feugiat felis. Vivamus ut sem ultrices tortor ultricies rutrum ut nec tellus. Vivamus et fermentum urna, vitae tempus nisi. Suspendisse facilisis augue justo, efficitur fermentum justo faucibus ut. Etiam consequat condimentum tincidunt. Etiam dictum orci at sem scelerisque ultricies. Proin laoreet iaculis odio, eget rutrum nulla dapibus ut. Praesent mi lacus, congue eget tincidunt a, tempus sed velit. Duis pulvinar odio eu mauris iaculis, eget venenatis velit auctor. Donec mollis faucibus molestie. Maecenas vel nisl ac ipsum maximus fringilla. Vivamus ut urna sodales mi rutrum varius. Nulla facilisi. Etiam malesuada faucibus felis, non posuere ligula luctus eu.\n" +
            "\n" +
            "Nunc elementum massa sed dolor euismod, eu semper sem rhoncus. Cras pulvinar odio sit amet tincidunt egestas. In magna turpis, facilisis nec ornare id, maximus volutpat neque. Aliquam felis tortor, condimentum vitae sem eu, finibus convallis ligula. Mauris ac libero at quam pharetra fermentum vel eu nunc. Curabitur sapien ex, ornare et enim vel, vestibulum ultricies tellus. Aenean venenatis purus nec nisi fringilla faucibus. Phasellus iaculis, leo quis placerat egestas, arcu libero venenatis lacus, eget cursus ipsum sem et orci. Aliquam ornare luctus ultrices. Nullam et viverra justo. Suspendisse rutrum, turpis ut condimentum commodo, purus augue placerat massa, ut pretium risus neque eget magna.\n" +
            "\n" +
            "Vivamus ex enim, eleifend at ligula sed, vehicula ornare arcu. Integer at sapien vitae purus bibendum hendrerit sed commodo arcu. Fusce ultricies risus eget gravida dapibus. Mauris pretium orci sit amet iaculis imperdiet. Vivamus cursus, turpis ac luctus rhoncus, mi eros sagittis tortor, sed rhoncus nisi tortor a tellus. Proin a enim risus. Aenean consectetur interdum dictum. Nunc pellentesque tortor purus, id ultricies erat lacinia vitae. Praesent aliquet turpis arcu, nec imperdiet velit rhoncus at. Vestibulum sodales posuere lorem ultricies blandit. Fusce nibh dui, facilisis sit amet accumsan facilisis, dictum eu mauris. Morbi ornare eros sit amet lacus maximus viverra ut nec nunc. Aenean vitae neque a nunc convallis sagittis. Vivamus non convallis sapien. Curabitur tincidunt velit odio. Phasellus pellentesque convallis massa, vel varius metus fermentum a.\n" +
            "\n" +
            "Interdum et malesuada fames ac ante ipsum primis in faucibus. Proin posuere dui sed viverra congue. Maecenas molestie tristique tellus ut condimentum. Cras dictum ultrices mauris, vitae molestie lectus. Cras id luctus turpis, ut sodales mauris. Nunc mattis facilisis egestas. Ut vitae porttitor metus. Duis vulputate dolor velit, vel dictum nisi accumsan eu. Integer quis magna quis augue vehicula scelerisque eu id turpis. Aliquam sodales dictum elit, nec porttitor lectus suscipit id. Fusce facilisis augue a pulvinar vehicula. Maecenas scelerisque massa sem, non maximus ligula scelerisque sed. Suspendisse ut vulputate mi. In hac habitasse platea dictumst.\n" +
            "\n" +
            "Sed efficitur non velit sit amet elementum. Suspendisse quam neque, blandit eu maximus sed, dictum eget erat. Mauris ut nibh euismod, mollis urna eu, vestibulum tellus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam in sapien nisi. Aliquam porta arcu molestie consectetur tempor. Quisque quis leo at eros lobortis dapibus sit amet lobortis justo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Proin sagittis metus ligula, id ultricies nunc venenatis ac. Vivamus consequat fringilla nisi, eu gravida turpis. In hac habitasse platea dictumst. Ut gravida iaculis consectetur.\n" +
            "\n" +
            "In hac habitasse platea dictumst. Mauris sit amet cursus lectus, id aliquet magna. Quisque tincidunt pellentesque nunc vel tincidunt. Vestibulum augue neque, eleifend pharetra ullamcorper at, ornare sit amet sem. Pellentesque porttitor eget risus ac faucibus. Aliquam lobortis quis felis eu sodales. Vivamus sagittis eu ex eu dapibus. In euismod accumsan risus ut imperdiet. Donec malesuada sagittis quam, facilisis hendrerit ex euismod nec. Duis lacinia nulla finibus, pellentesque eros a, sollicitudin quam. Nam maximus, ante in luctus tempor, felis erat ultrices elit, eget vulputate augue neque auctor lacus. Aliquam rutrum, sapien quis rhoncus luctus, arcu felis pulvinar eros, ut porta lectus risus vel erat.";

    @Autowired
    UserRepository userRepository;

    @Autowired
    DocumentRepository documentRepository;

    @GetMapping("/document/{title}")
    public String document(Model model, @PathVariable String title) {
        List<User> list = (List<User>) userRepository.findAll();
        model.addAttribute("title", title);
        model.addAttribute("content", "Content of " + title + "\n" + loremIpsum);
        return "document";
    }
    @GetMapping("/document/edit/{title}")
    public String edit(Model model, @PathVariable String title) {
        List<User> list = (List<User>) userRepository.findAll();
        model.addAttribute("title", title);
        model.addAttribute("content", "Content of " + title + "\n" + loremIpsum);
        return "edit";
    }

    @PostMapping(value = "/document/save")
    public String save(Model model, @ModelAttribute Document document) {
        documentRepository.save(document);
        return "redirect:/document/" + document.getTitle();
    }

}
