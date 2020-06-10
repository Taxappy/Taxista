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

	@GetMapping("/")
	public Iterable<Taxista> allTaxista() {
		return taxistaRepository.findAll();
	}

	@GetMapping("/{idTaxista}")
	public Taxista findByidTaxista(@PathVariable final int idTaxista) {
		return taxistaRepository.findTaxistaByIdTaxista(idTaxista);
	}

	@PostMapping("/")
	public Taxista saveTaxista(@RequestBody Taxista taxista) {
		return taxistaRepository.save(taxista);

	}

	@DeleteMapping("/{idTaxista}")
	public void deleteTaxista(@PathVariable final int idTaxista) {
		taxistaRepository.deleteById(idTaxista);
	}

	@PatchMapping("/")
	public Taxista updateTaxista(@RequestBody Taxista taxista) {
		return taxistaRepository.save(taxista);
	}

	@GetMapping("/notificacion")
	public List<Notification> getNotificacion() {
		return notificaciones;
	}

	@PostMapping("/usotaxi")
	public UsoTaxi saveUsoTaxi(@RequestBody UsoTaxi usoTaxi) {
		return usoTaxiRepository.save(usoTaxi);
	}

	@PatchMapping("/usotaxi")
	public UsoTaxi updateUsoTaxi(@RequestBody UsoTaxi usoTaxi) {
		return usoTaxiRepository.save(usoTaxi);
	}

	@GetMapping("/usotaxi")
	public Iterable<UsoTaxi> allUsoTaxi() {
		return usoTaxiRepository.findAll();
	}

	@GetMapping("/usotaxi/{idTaxista}/placa/{placa}")
	public UsoTaxi findByIdTaxistaAndPlaca(@PathVariable int idTaxista, @PathVariable String placa) {
		return usoTaxiRepository.findUsoTaxiByIdTaxistaAndPlaca(idTaxista, placa);
	}

	@GetMapping("/usotaxi/{idTaxista}/fecha/{fechaUso}")
	public UsoTaxi findByIdTaxistaAndFechaUso(@PathVariable int idTaxista,@PathVariable String fechaUso) {
		return usoTaxiRepository.findUsoTaxiByIdTaxistaAndFechaUso(idTaxista, fechaUso);
	}

	@DeleteMapping("/usotaxi/{codigo}")
	public void deleteUsoTaxi(@PathVariable int codigo) {
		usoTaxiRepository.deleteById(codigo);
	}

	@StreamListener(NotificationSaveStream.INPUT)
	public void saveNotification(@Payload Notification notificacion) {
		notificaciones.add(notificacion);
	}

	@StreamListener(NotificationDeleteStream.INPUT)
	public void deleteNotification(@Payload Notification notificacion) {
		notificaciones.remove(notificacion);

	}

}
