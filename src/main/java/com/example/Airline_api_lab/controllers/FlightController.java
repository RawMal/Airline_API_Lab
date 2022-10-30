import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerService passengerService;

    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable long id){
        return new ResponseEntity<>(flightService.getFlightById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        Flight savedFlight = flightService.saveFlight(flight);
        return new ResponseEntity<>(savedFlight,HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{flightId}")
    public ResponseEntity<Flight> addPassengerToFlight(@PathVariable long flightId,@RequestParam long passengerId){
        Flight flight = flightService.addPassengerToFlight(flightId,passengerId);
        return new ResponseEntity<>(flight,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Flight>> cancelFlightById(@PathVariable long id){
        flightService.cancelFlightById(id);
        return new ResponseEntity<>(flightService.getAllFlights(),HttpStatus.OK);
    }

}
