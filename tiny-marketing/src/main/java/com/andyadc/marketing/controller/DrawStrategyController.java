package com.andyadc.marketing.controller;

import com.andyadc.codecraft.base.core.model.Response;
import com.andyadc.marketing.api.dto.ActivityDrawRequestDTO;
import com.andyadc.marketing.api.dto.ActivityDrawResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/draw/strategy")
@RestController
public class DrawStrategyController {

	@RequestMapping(value = "/draw", method = RequestMethod.POST)
	public Response<ActivityDrawResponseDTO> draw(@RequestBody ActivityDrawRequestDTO request) {

		ActivityDrawResponseDTO responseDTO = new ActivityDrawResponseDTO();
		Response<ActivityDrawResponseDTO> response = Response.<ActivityDrawResponseDTO>builder()
			.code("")
			.message("")
			.data(responseDTO)
			.build();

		return response;
	}
}
