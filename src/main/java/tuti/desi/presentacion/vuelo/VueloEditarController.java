package tuti.desi.presentacion.vuelo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;

import tuti.desi.servicios.CiudadService;

import tuti.desi.servicios.VueloService;

public class VueloEditarController {
	@Autowired
    private VueloService service;
	@Autowired
    private CiudadService serviceCiudad;
     
    @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> nroVuelo) throws Exception {
    	if (nroVuelo.isPresent()) {
    		Vuelo entity = service.getVueloById(nroVuelo.get());
    		VueloForm form = new VueloForm(entity);
    		modelo.addAttribute("formBean", form);
		} else {
		   modelo.addAttribute("formBean",new VueloForm());
		}
       return "personasEditar";
    }
     
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deletePersonaById(Model model, @PathVariable("id") Long id) 
	{
		service.deleteVueloByid(id);
		return "redirect:/personasBuscar";
	}
 
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid VueloForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) throws Exception  {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    		//para poner errores personalizados asociados a
//            FieldError error2 = new FieldError("formBean","dni","este es otro error.");
//            result.addError(error2);
//    		ObjectError error = new ObjectError("globalError", "aplicacion en modo demo, no puede continuar");
//            result.addError(error);
            
    		if(result.hasErrors())
    		{
    			
                
    			modelo.addAttribute("formBean",formBean);
    			 return "programarVuelo";
    		}
    		else
    		{
    			Vuelo v=formBean.toPojo();
    			v.setOrigen(serviceCiudad.getById(formBean.getIdCiudad()));
    			try {
    				service.save(v);
					
					return "redirect:/buscarVuelo";
				} catch (Excepcion e) {
					if(e.getAtributo()==null) //si la excepcion estuviera referida a un atributo del objeto, entonces mostrarlo al lado del compornente (ej. dni)
					{
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            result.addError(error);
					}
					else
					{
			    		FieldError error1 = new FieldError("formBean",e.getAtributo(),e.getMessage());
			            result.addError(error1);

					}
		            
		            
		            modelo.addAttribute("formBean",formBean);
	    			return "programarVuelo";//Como existe un error me quedo en la misma pantalla
				}
    		}

    		
        	
        	
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/buscarVuelo";
    	}
    		
    	return "redirect:/";
    	
    	
    }

}
