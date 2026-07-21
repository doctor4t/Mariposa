package dev.doctor4t.mariposa.fabric.common;

import com.google.auto.service.AutoService;
import dev.doctor4t.mariposa.common.MariposaService;

@AutoService(MariposaService.class)
public class MariposaFabricService implements MariposaService {
	@Override
	public void initTerraBlender() {
	}
}
