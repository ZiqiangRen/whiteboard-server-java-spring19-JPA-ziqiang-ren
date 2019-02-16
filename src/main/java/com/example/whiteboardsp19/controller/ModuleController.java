package com.example.whiteboardsp19.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.model.Module;
import com.example.whiteboardsp19.services.ModuleService;

@RestController
public class ModuleController {

    private final ModuleService moduleService;

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @DeleteMapping("/api/modules/{mid}")
    public List<Module> deleteModule(@PathVariable("mid") int mid) {
        return moduleService.deleteModule(mid);
    }


    @PutMapping("/api/modules/{mid}")
    public Module updateModule(@PathVariable("mid") Integer mid, @RequestBody Module newModule) {
        return moduleService.updateModule(mid, newModule);
    }

    @PostMapping("/api/courses/{cid}/modules")
    public List<Module> createModule(@PathVariable("cid") Integer cid, @RequestBody Module module) {
        return moduleService.createModule(cid, module);
    }

    @GetMapping("/api/courses/{cid}/modules")
    public List<Module> findAllModules(@PathVariable("cid") Integer cid) {
        return moduleService.findAllModules(cid);
    }

    @GetMapping("/api/modules/{mid}")
    public Module findModuleById(@PathVariable("mid") Integer mid) {
        return moduleService.findModuleById(mid);
    }

}