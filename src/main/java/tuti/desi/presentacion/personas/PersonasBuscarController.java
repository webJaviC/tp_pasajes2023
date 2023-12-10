package tuti.desi.presentacion.personas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Persona;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.PersonaService;


@Controller
@RequestMapping("/personasBuscar")
public class PersonasBuscarController {
	@Autowired
    private PersonaService service;
	@Autowired
    private CiudadService serviceCiudad;
     
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) {
    	PersonasBuscarForm form =  new PersonasBuscarForm();
    	form.setIdCiudadSeleccionada(1L); //Esto es por ejemplo, si quisiera setear un valor por defecto en el filtro de ciudad 
//    	 form.setCiudades(serviceCiudad.getAll());    //  en lugar de esto hacemos @ModelAttribute("allCiudades")
       modelo.addAttribute("formBean",form);
       return "personasBuscar";
    }
     
    
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( @ModelAttribute("formBean")  @Valid  PersonasBuscarForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
         	
    	
    	if(action.equals("Buscar"))
    	{
    		
    		
    		try {
    			List<Persona> personas = service.filter(formBean);
            	modelo.addAttribute("resultados",personas);
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
			}
        	modelo.addAttribute("formBean",formBean);
        	return "personasBuscar";
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    	
    	if(action.equals("Registrar"))
    	{
    		modelo.clear();
    		return "redirect:/personasEditar";
    	}
    		
    	return "redirect:/";
    	
    	
    }

 
}
