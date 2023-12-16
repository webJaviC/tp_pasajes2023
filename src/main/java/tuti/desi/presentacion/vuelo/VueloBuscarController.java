package tuti.desi.presentacion.vuelo;

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

import tuti.desi.entidades.Vuelo;



import tuti.desi.servicios.VueloService;

@Controller
	@RequestMapping("/programarVuelo")

public class VueloBuscarController {

	
	
		@Autowired
	    private VueloService service;
		
	     
	    @RequestMapping(method=RequestMethod.GET)
	    public String preparaForm(Model modelo) {
	    	VueloBuscarForm form =  new VueloBuscarForm();
	    	modelo.addAttribute("formBean",form);
	       return "buscarVuelo";
	    }
	     
	    
	 
	    
	    @RequestMapping( method=RequestMethod.POST)
	    public String submit( @ModelAttribute("formBean")  @Valid VueloBuscarForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
	         	
	    	
	    	if(action.equals("Buscar"))
	    	{
	    		
	    		
	    		try {
	    			List<Vuelo> vuelo = service.filter(formBean);
	            	modelo.addAttribute("resultados",vuelo);
				} catch (Exception e) {
					ObjectError error = new ObjectError("globalError", e.getMessage());
		            result.addError(error);
				}
	        	modelo.addAttribute("formBean",formBean);
	        	return "programarVuelo";
	    	}
	    
	    	
	    	if(action.equals("Cancelar"))
	    	{
	    		modelo.clear();
	    		return "redirect:/";
	    	}
	    	
	    	if(action.equals("Registrar"))
	    	{
	    		modelo.clear();
	    		return "redirect:/programarVuelo";
	    	}
	    		
	    	return "redirect:/";
	    	
	    	
	    }

}
