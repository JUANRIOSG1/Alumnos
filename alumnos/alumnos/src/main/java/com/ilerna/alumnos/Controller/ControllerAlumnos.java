package com.ilerna.alumnos.Controller;

import com.ilerna.alumnos.entity.Alumnos;
import com.ilerna.alumnos.service.GestorAlumnos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/alumnos")
public class ControllerAlumnos {
    GestorAlumnos ge = new GestorAlumnos ();
    @GetMapping("/")
    public String crud(Model model){
        String valorfinal="./alumnos/listaralumnos";
        try {
            model.addAttribute("alumnos", ge.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
    }
    @GetMapping("/alta")
    public String greetingForm(Model model) {
        model.addAttribute("alumnos", new Alumnos());
        return "./alumnos/altaalumnos";
    }
    @PostMapping("/alta")
    public String greetingSubmit(@ModelAttribute Alumnos alumnos, Model model) {
        String valorfinal="redirect:/alumnos/";
        try {
            ge.alta(alumnos);
            try {
                model.addAttribute("alumnos", ge.listar());
            } catch (SQLException ex) {
                Logger.getLogger(ControllerAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
    }
    @GetMapping("/eliminar")
    public String SubmitB (@RequestParam("codalumnos") int id, Model model){
        String valorfinal="redirect:/alumnos/";
        try {
            ge.eliminar(id);
            model.addAttribute("alumnos", ge.listar());
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
    }
    @GetMapping("/modificar")
    public String modificar(@RequestParam ("codalumnos") int id,Model model){
        String valorfinal="./alumnos/modificaralumnos";
        try {
            model.addAttribute("alumnos", ge.buscar(id));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
    }
    @PostMapping("/modificar")
    public String modificarBBDD (@ModelAttribute Alumnos alumnos, Model model){
        String valorfinal="redirect:/alumnos/";
        try {
            ge.modificar(alumnos);
            model.addAttribute("alumnos",ge.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
    }
}
