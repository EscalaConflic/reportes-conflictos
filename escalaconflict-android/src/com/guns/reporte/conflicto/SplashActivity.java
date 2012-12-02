package com.guns.reporte.conflicto;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.AlphaModifier;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.RotationByModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.modifier.LoopEntityModifier.ILoopEntityModifierListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.modifier.IModifier;
import org.andengine.util.modifier.LoopModifier;
import org.andengine.util.modifier.ease.EaseCircularOut;
import android.opengl.GLES20;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class SplashActivity extends SimpleBaseGameActivity{
	
	private BitmapTextureAtlas mapa;
	private BitmapTextureAtlas mapa1;
	private TextureRegion tfondo1;
	private TextureRegion tfondo2;
	private TextureRegion textura;
	private TextureRegion ttitulo1;
	private TextureRegion ttitulo2;
	private TextureRegion textura2;
	private TextureRegion textura3;
	private TextureRegion textura4;
	private TextureRegion textura5;
	
	private Sprite fondo1;
	private Sprite fondo2;
	private Sprite mundo;
	private Sprite titulo;
	private Sprite subtitulo;
	private Sprite barrita1;
	private Sprite barrita2;
	private Sprite barrita3;
	private Sprite tapado;
	private int n=1;
	private int pos;
	@Override
	public EngineOptions onCreateEngineOptions() {
		final Camera camara = new Camera(0,0,480,800);
		EngineOptions as = new EngineOptions(true,ScreenOrientation.PORTRAIT_FIXED,new FillResolutionPolicy(),camara);
		as.getAudioOptions().setNeedsMusic(true);
		return as;
	}

	@Override
	protected void onCreateResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("imagenSplash/");
		this.mapa = new BitmapTextureAtlas(this.getTextureManager(),480,
				1939, TextureOptions.BILINEAR);
		
		this.mapa1 = new BitmapTextureAtlas(this.getTextureManager(), 480,
				902, TextureOptions.BILINEAR);   
		this.tfondo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa, this, "fondo1.png", 0, 0);
		this.tfondo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa, this, "fondo2.png", 0, 800);
		this.textura = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa, this, "MUNDO.png", 0, 1601);
		this.ttitulo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa1, this, "titular1.png", 0, 0);
		this.ttitulo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa1, this, "titular2.png", 0, 106);
		this.textura2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa1, this, "titular3.png", 0, 180);
		this.textura3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa1, this, "A.png", 0, 266);
		this.textura4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa1, this, "B.png", 0, 500);
		this.textura5 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa1, this, "C.png", 0, 734);
		this.mapa.load();
		this.mapa1.load();
	}

	@Override
	protected Scene onCreateScene() {
		Scene escena = new Scene();
		mundo = new Sprite(240-textura.getWidth()/2,300-textura.getHeight()/2,this.textura,this.getVertexBufferObjectManager());
		fondo1 = new Sprite(0,0,this.tfondo1,this.getVertexBufferObjectManager());
		fondo2 = new Sprite(0,0,this.tfondo2,this.getVertexBufferObjectManager());
		escena.attachChild(fondo2);
		escena.attachChild(fondo1);
		
		fondo2.setVisible(false);
		titulo = new Sprite(280-textura.getWidth()/2,500,this.ttitulo1,this.getVertexBufferObjectManager());
		subtitulo = new Sprite(220-textura.getWidth()/2,580,this.ttitulo2,this.getVertexBufferObjectManager());
		tapado = new Sprite(0,587,this.textura3,this.getVertexBufferObjectManager());
		barrita1 = new Sprite(260-textura.getWidth()/2,tapado.getY(),this.textura2,this.getVertexBufferObjectManager());
		barrita2 = new Sprite(barrita1.getX()+20,tapado.getY(),this.textura2,this.getVertexBufferObjectManager());
		barrita3 = new Sprite(barrita2.getX()+20,tapado.getY(),this.textura2,this.getVertexBufferObjectManager());
		escena.attachChild(barrita1);
		escena.attachChild(barrita2);
		escena.attachChild(barrita3);
		escena.attachChild(tapado);
		escena.attachChild(titulo);
		escena.attachChild(subtitulo);
		mundo.setBlendFunction(GLES20.GL_SRC_ALPHA,GLES20.GL_ONE_MINUS_SRC_ALPHA);
		fondo1.setBlendFunction(GLES20.GL_SRC_ALPHA,GLES20.GL_ONE_MINUS_SRC_ALPHA);
		fondo2.setBlendFunction(GLES20.GL_SRC_ALPHA,GLES20.GL_ONE_MINUS_SRC_ALPHA);
		titulo.setBlendFunction(GLES20.GL_SRC_ALPHA,GLES20.GL_ONE_MINUS_SRC_ALPHA);
		subtitulo.setBlendFunction(GLES20.GL_SRC_ALPHA,GLES20.GL_ONE_MINUS_SRC_ALPHA);
		mundo.setAlpha(0);
		fondo1.setAlpha(0);
		titulo.setAlpha(0);
		subtitulo.setAlpha(0);
		titulo.setScale(0.7f);
		subtitulo.setScale(0.7f);
		final LoopEntityModifier entityModifier = new LoopEntityModifier(
				new IEntityModifierListener(){

					@Override
					public void onModifierFinished(
							IModifier<IEntity> pModifier, IEntity pItem) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onModifierStarted(IModifier<IEntity> pModifier,
							IEntity pItem) {
						// TODO Auto-generated method stub
						
					}},1, new ILoopEntityModifierListener(){

						@Override
						public void onLoopStarted(
								LoopModifier<IEntity> pLoopModifier, int pLoop,
								int pLoopCount) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onLoopFinished(
								LoopModifier<IEntity> pLoopModifier, int pLoop,
								int pLoopCount) {
							
		             
							// TODO Auto-generated method stub
							
							//SplashActivity.CambiarEscena(1);
							/*Intent a = new Intent(SplashActivity.this,dashboard.class);
							                 startActivity(a);
							                 SplashActivity.this.finish();*/
							
							animacionesBarras(barrita1);
						}},
						new SequenceEntityModifier(
								 
								new DelayModifier(2),
								new AlphaModifier(2f,0,1)

								//,new DelayModifier(2)
								
								
								//,new DelayModifier(0.5f)
								)
				);
		
		mundo.registerEntityModifier(entityModifier);
		fondo1.registerEntityModifier(entityModifier);
		titulo.registerEntityModifier(entityModifier);
		subtitulo.registerEntityModifier(entityModifier);
		mundo.registerEntityModifier(new RotationByModifier(50, 360));
		//titulo.registerEntityModifier(new AlphaModifier(1.5f,0,1));
		escena.attachChild(mundo);
		return escena;
	}
	public void animacionesBarras(final Sprite b){
		
		switch(n){
		case 1:
			pos=560;
			break;
			
		case 2:
			pos=540;
			break;
			
		case 3:
			pos=520;
			break;
		}
		final LoopEntityModifier barrita = new LoopEntityModifier(
				new IEntityModifierListener(){

					@Override
					public void onModifierFinished(
							IModifier<IEntity> pModifier, IEntity pItem) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onModifierStarted(IModifier<IEntity> pModifier,
							IEntity pItem) {
						// TODO Auto-generated method stub
						
					}},1, new ILoopEntityModifierListener(){

						@Override
						public void onLoopStarted(
								LoopModifier<IEntity> pLoopModifier, int pLoop,
								int pLoopCount) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onLoopFinished(
								LoopModifier<IEntity> pLoopModifier, int pLoop,
								int pLoopCount) {
							
							switch(n){
							case 1:
								n++;
								animacionesBarras(barrita2);
								break;
								
							case 2:
								n++;
								animacionesBarras(barrita3);
								break;
								
							case 3:
								n++;
								//fondo2.setVisible(true);
								//fondo1.registerEntityModifier(new AlphaModifier(1f,1,0));
								//fondo2.registerEntityModifier(new AlphaModifier(1f,0,1));
								break;
							
							}
							
							
							
						}},
						new SequenceEntityModifier(
								new MoveModifier(0.5f, b.getX(), b.getX(), b.getY(), pos, EaseCircularOut.getInstance())
								)
				);
		b.registerEntityModifier(barrita);
	}
}

