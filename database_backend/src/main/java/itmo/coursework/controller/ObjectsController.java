package itmo.coursework.controller;

import itmo.coursework.entity.Objects;
import itmo.coursework.service.ObjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/databases/object")
@RequiredArgsConstructor
public class ObjectsController {
    private final ObjectsService objectsService;

    @GetMapping( "/getAllObjects")
    public @ResponseBody
    ResponseEntity getAllObjects() {
        List<Objects> objectsAvailabilityList = objectsService.getAllObjects();
        return ResponseEntity.status(HttpStatus.OK).body(objectsAvailabilityList);
    }

    @PostMapping( "/createObject")
    public @ResponseBody ResponseEntity createObject(String name, String description, int price, int amount) {
        Objects object = objectsService.createObject(name, description, price, amount);
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    @PostMapping( "/deleteObject")
    public @ResponseBody ResponseEntity deleteObject(long uid) {
        objectsService.deleteObject(uid);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @PostMapping( "/updateObject")
    public @ResponseBody ResponseEntity updateObject(long uid, String name, String description, int price, int amount) {
        objectsService.updateObject(uid, name, description, price, amount);
        return ResponseEntity.status(HttpStatus.OK).body("updated");
    }

    @GetMapping( "/findObjectByName")
    public @ResponseBody ResponseEntity findObjectByName(String name) {
        List<Objects> objects = objectsService.findObjectsByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(objects);
    }
}
