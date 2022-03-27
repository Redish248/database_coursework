package itmo.coursework.controller;

import itmo.coursework.entity.statistic.Objects;
import itmo.coursework.service.ObjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/databases/objects")
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
    public @ResponseBody ResponseEntity createObject(@RequestBody Objects newObject) {
        Objects object = objectsService.createObject(newObject);
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    @PostMapping( "/updateObject")
    public @ResponseBody ResponseEntity updateObject(@RequestBody Objects object) {
        Objects newObject = objectsService.updateObject(object);
        return ResponseEntity.status(HttpStatus.OK).body("updated");
    }

    @DeleteMapping( "/deleteObject/{uid}")
    public @ResponseBody ResponseEntity deleteObject(@PathVariable long uid) {
        objectsService.deleteObject(uid);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
