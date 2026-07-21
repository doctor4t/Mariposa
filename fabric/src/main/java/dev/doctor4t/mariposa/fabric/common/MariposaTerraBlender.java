package dev.doctor4t.mariposa.fabric.common;

import dev.doctor4t.mariposa.common.Mariposa;
import terrablender.api.TerraBlenderApi;

public class MariposaTerraBlender implements TerraBlenderApi {
	@Override
	public void onTerraBlenderInitialized() {
		Mariposa.initTerraBlender();
	}
}
