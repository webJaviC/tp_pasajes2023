package tuti.desi.presentacion.vuelo;
@RestController
@RequestMapping("/flights")
public class VueloEditarController {
	 @Autowired
	    private FlightService flightService;

	    @PostMapping
	    public ResponseEntity<Flight> createFlight(@Valid @RequestBody Flight flight) {
	        Flight newFlight = flightService.createFlight(flight);
	        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
	    }

}
