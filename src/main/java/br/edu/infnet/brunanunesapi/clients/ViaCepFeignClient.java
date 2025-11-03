package br.edu.infnet.brunanunesapi.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.brunanunesapi.model.domain.Address;

@FeignClient(name = "viacep", url = "${api.viacep.url}")
public interface ViaCepFeignClient {

	@GetMapping("/{cep}/json/")
	Address findByCep(@PathVariable String cep);
}