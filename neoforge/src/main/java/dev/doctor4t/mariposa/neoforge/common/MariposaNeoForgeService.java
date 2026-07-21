package dev.doctor4t.mariposa.neoforge.common;

import com.google.auto.service.AutoService;
import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.MariposaService;

@AutoService(MariposaService.class)
public class MariposaNeoForgeService implements MariposaService {
	@Override
	public void initTerraBlender() {
		Mariposa.initTerraBlender();
	}
}
