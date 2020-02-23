package com.taxappy.taxista.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taxappy.taxista.model.Notification;
import com.taxappy.taxista.model.Taxista;
import com.taxappy.taxista.model.UsoTaxi;
import com.taxappy.taxista.stream.NotificationDeleteStream;
import com.taxappy.taxista.stream.NotificationSaveStream;
import com.taxappy.taxista.repository.TaxistaRepository;
import com.taxappy.taxista.repository.UsoTaxiRepository;



@RestController
@RequestMapping("/")
public class TaxistaController {
	@Autowired
	private TaxistaRepository taxistaRepository;
	@Autowired
	private UsoTaxiRepository usoTaxiRepository;
	private List<Notification> notificaciones = new ArrayList<>();

	@GetMapping("/taxista")
	public Iterable<Taxista> allTaxista() {
		return taxistaRepository.findAll();
	}

	@GetMapping("/taxista/{id}")
	public Taxista findByidTaxista(@PathVariable final int idTaxista) {
		return taxistaRepository.findTaxistaByIdTaxista(idTaxista);
	}

	@PostMapping("/taxista")
	public Taxista save(@RequestBody Taxista taxista) {
		return taxistaRepository.save(taxista);

	}

	@DeleteMapping("/taxista")
	public void delete(@RequestBody Taxista taxista) {
		taxistaRepository.delete(taxista);
	}

	@PatchMapping("/taxista")
	public Taxista update(@RequestBody Taxista taxista) {
		return taxistaRepository.save(taxista);
	}

	@StreamListener(NotificationSaveStream.INPUT)
	public void saveNotification(@Payload Notification notificacion) {
		notificaciones.add(notificacion);
	}

	@StreamListener(NotificationDeleteStream.INPUT)
	public void deleteNotification(@Payload Notification notificacion) {
		notificaciones.remove(notificacion);

	}

	@GetMapping("/taxista/notificacion")
	public List<Notification> getNotificacion() {
		return notificaciones;
	}

	@PostMapping("/taxista/usotaxi")
	public UsoTaxi save(@RequestBody UsoTaxi usoTaxi) {
		return usoTaxiRepository.save(usoTaxi);
	}

	@PatchMapping("/taxista/usotaxi")
	public UsoTaxi update(@RequestBody UsoTaxi usoTaxi) {
		return usoTaxiRepository.save(usoTaxi);
	}

	@GetMapping("/taxista/usotaxi")
	public Iterable<UsoTaxi> allUsoTaxi() {
		return usoTaxiRepository.findAll();
	}

	@GetMapping("/taxista/usotaxi/{idTaxista}")
	public UsoTaxi findByIdTaxistaAndPlaca(@PathVariable int idTaxista, @RequestParam String placa) {
		return usoTaxiRepository.findUsoTaxiByIdTaxistaAndPlaca(idTaxista, placa);
	}

	@GetMapping("/taxista/usotaxi/{fechaUso}")
	public UsoTaxi findByIdTaxistaAndFechaUso(@RequestParam int idTaxista,@PathVariable String fechaUso) {
		return usoTaxiRepository.findUsoTaxiByIdTaxistaAndFechaUso(idTaxista, fechaUso);
	}

	@DeleteMapping("/taxista/usotaxi")
	public void delete(@RequestBody UsoTaxi usotaxi) {
		usoTaxiRepository.delete(usotaxi);
	}

}
