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
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.modifier.LoopEntityModifier.ILoopEntityModifierListener;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.modifier.IModifier;
import org.andengine.util.modifier.LoopModifier;
import org.andengine.util.modifier.ease.EaseBackOut;
import org.andengine.util.modifier.ease.EaseCircularOut;

import android.content.Intent;
import android.net.Uri;
import android.opengl.GLES20;
import android.widget.TextView;

/**   
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class SplashActivity extends SimpleBaseGameActivity implements IOnSceneTouchListener{
	
	private BitmapTextureAtlas mapa;
	private BitmapTextureAtlas mapa1;
	private BitmapTextureAtlas mapa2;
	private TextureRegion tcredit;
	private Sprite creditos;
	private TextureRegion tfondo1;
	private TextureRegion tfondo2;
	private TextureRegion textura;
	private TextureRegion ttitulo1;
	private TextureRegion ttitulo2;
	private TiledTextureRegion textras;
	private TiledTextureRegion tbotones;
	private TiledTextureRegion tbotonesR;
	private Sprite fondo1;
	private Sprite fondo2;
	private Sprite mundo;
	private Sprite titulo;
	private Sprite barrita1;
	private Sprite barrita2;
	private Sprite barrita3;
	private AnimatedSprite item1;
	private AnimatedSprite item2;
	private AnimatedSprite item3;
	private AnimatedSprite item4;
    private AnimatedSprite boton1;
    private AnimatedSprite boton2;
    private AnimatedSprite boton3;
    private AnimatedSprite boton4;
    private AnimatedSprite boton5;
    private AnimatedSprite boton6;
    private AnimatedSprite boton7;
    
	private int n=1;
	private float pos;
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
		this.mapa = new BitmapTextureAtlas(this.getTextureManager(),678,
				1939, TextureOptions.BILINEAR);
		
		this.mapa1 = new BitmapTextureAtlas(this.getTextureManager(), 678,
				1046, TextureOptions.BILINEAR);
		this.mapa2 = new BitmapTextureAtlas(this.getTextureManager(), 480,
				800, TextureOptions.BILINEAR);
		this.tcredit = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa2, this, "creditos.png", 0, 0);
		this.tfondo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa, this, "fondo1.png", 0, 0);
		this.tfondo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa, this, "fondo2.png", 0, 800);
		this.textura = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa, this, "MUNDO.png", 0, 1601);
		this.ttitulo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa1, this, "titularFINAL.png", 0, 0);
		this.ttitulo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mapa1, this, "BARRAFINAL.png", 0, 126);
		this.tbotones = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mapa1, this, "botones.png", 0, 184,2,4);
		this.tbotonesR = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mapa1, this, "redes.png", 0, 777,3,2);
		this.textras = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mapa1, this, "extras.png", 226, 777,2,2);
		this.mapa.load();
		this.mapa1.load();
		this.mapa2.load();
	}

	@Override
	protected Scene onCreateScene() {
		boton1 = new AnimatedSprite(-tbotones.getWidth(),50,tbotones,this.getVertexBufferObjectManager()){
			  
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if(pSceneTouchEvent.isActionDown()){
					
						this.setCurrentTileIndex(1);
					
					}
					if(pSceneTouchEvent.isActionUp()){
						
							this.setCurrentTileIndex(0);
							Intent reportarIntent = new Intent(SplashActivity.this, reporte.class);
							startActivity(reportarIntent);
							//SplashActivity.this.finish();
					}		
					
					
					
				
				return false;
			}
		};
		boton2 = new AnimatedSprite(-tbotones.getWidth(),550,tbotones,this.getVertexBufferObjectManager()){
			  
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if(pSceneTouchEvent.isActionDown()){
					
					this.setCurrentTileIndex(3);
				
				}
				if(pSceneTouchEvent.isActionUp()){
					
						this.setCurrentTileIndex(2);
						
				}
				return false;
			}
		};
		boton3 = new AnimatedSprite(800+tbotones.getWidth(),550,tbotones,this.getVertexBufferObjectManager()){
			  
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if(pSceneTouchEvent.isActionDown()){
					
					this.setCurrentTileIndex(5);
				
				}
				if(pSceneTouchEvent.isActionUp()){
					
						this.setCurrentTileIndex(4);
						Intent reportarIntent = new Intent(SplashActivity.this, mapapuntasos.class);
						startActivity(reportarIntent);
				}
				return false;
			}
		};
		boton4 = new AnimatedSprite(800+tbotones.getWidth(),50,tbotones,this.getVertexBufferObjectManager()){
			  
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if(pSceneTouchEvent.isActionDown()){
					
					this.setCurrentTileIndex(7);
				
				}
				if(pSceneTouchEvent.isActionUp()){
					
						this.setCurrentTileIndex(6);
						Intent reportarIntent = new Intent(SplashActivity.this, ReportesTortas.class);
						startActivity(reportarIntent);
				}
				return false;
			}
		};
		boton5 = new AnimatedSprite(10,715,tbotonesR,this.getVertexBufferObjectManager()){
			  
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if(pSceneTouchEvent.isActionDown()){
					
					this.setCurrentTileIndex(3);
				
				}
				if(pSceneTouchEvent.isActionUp() ){
					creditos.registerEntityModifier(new AlphaModifier(0.5f,0,1));
						this.setCurrentTileIndex(0);
						
				}
				return false;
			}
		};
		boton6 = new AnimatedSprite(boton5.getX()-15+tbotonesR.getWidth(),715,tbotonesR,this.getVertexBufferObjectManager()){
			  
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if(pSceneTouchEvent.isActionDown()){
					
					this.setCurrentTileIndex(4);
				
				}
				if(pSceneTouchEvent.isActionUp()){
					
						this.setCurrentTileIndex(1);
						startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com") ) );
				}
				return false;
			}
		};
		boton7 = new AnimatedSprite(boton6.getX()-15+tbotonesR.getWidth(),715,tbotonesR,this.getVertexBufferObjectManager()){
			  
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if(pSceneTouchEvent.isActionDown()){
					
					this.setCurrentTileIndex(5);
				
				}
				if(pSceneTouchEvent.isActionUp()){
					
						this.setCurrentTileIndex(2);
						startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/escalaconflict") ) );
				}
				return false;
			}
		};
		boton1.setTag(0);
		boton2.setTag(0);
		boton3.setTag(0);
		boton4.setTag(0);
		boton5.setTag(0);
		boton6.setTag(0);
		boton7.setTag(0);
		item1 = new AnimatedSprite(10,160,textras,this.getVertexBufferObjectManager());
		item2 = new AnimatedSprite(10,470,textras,this.getVertexBufferObjectManager());
		item3 = new AnimatedSprite(470-textras.getWidth(),470,textras,this.getVertexBufferObjectManager());
		item4 = new AnimatedSprite(470-textras.getWidth(),160,textras,this.getVertexBufferObjectManager());
		item2.setCurrentTileIndex(2);
		item3.setCurrentTileIndex(1);
		item4.setCurrentTileIndex(3);
		boton1.setCurrentTileIndex(0);
		boton2.setCurrentTileIndex(2);
		boton3.setCurrentTileIndex(4);
		boton4.setCurrentTileIndex(6);
		boton5.setCurrentTileIndex(0);
		boton6.setCurrentTileIndex(1);
		boton7.setCurrentTileIndex(2);
		
		Scene escena = new Scene();
		escena.setOnSceneTouchListener(this);
		mundo = new Sprite(240-textura.getWidth()/2,370-textura.getHeight()/2,this.textura,this.getVertexBufferObjectManager());
		fondo1 = new Sprite(0,0,this.tfondo1,this.getVertexBufferObjectManager());
		fondo2 = new Sprite(0,0,this.tfondo2,this.getVertexBufferObjectManager());
		
		escena.attachChild(fondo2);
		escena.attachChild(boton5);
		escena.attachChild(boton6);
		escena.attachChild(boton7);
		escena.attachChild(item1);
		escena.attachChild(item2);
		escena.attachChild(item3);
		escena.attachChild(item4);
		escena.attachChild(fondo1);
		fondo2.setVisible(false);   
		titulo = new Sprite(265-textura.getWidth()/2,580,this.ttitulo1,this.getVertexBufferObjectManager());
		barrita1 = new Sprite(265-textura.getWidth()/2,titulo.getY()+ttitulo1.getHeight()/2,this.ttitulo2,this.getVertexBufferObjectManager());
		barrita2 = new Sprite(barrita1.getX()+ttitulo2.getWidth()+3,titulo.getY()+ttitulo1.getHeight()/2,this.ttitulo2,this.getVertexBufferObjectManager());
		barrita3 = new Sprite(barrita2.getX()+ttitulo2.getWidth()+3,titulo.getY()+ttitulo1.getHeight()/2,this.ttitulo2,this.getVertexBufferObjectManager());
		//tapado.setFlippedVertical(true);
		barrita1.setScale(0f);
		barrita2.setScale(0f);
		barrita3.setScale(0f);
		escena.attachChild(barrita1);
		escena.attachChild(barrita2);
		escena.attachChild(barrita3);
		escena.attachChild(titulo);
		mundo.setBlendFunction(GLES20.GL_SRC_ALPHA,GLES20.GL_ONE_MINUS_SRC_ALPHA);
		fondo1.setBlendFunction(GLES20.GL_SRC_ALPHA,GLES20.GL_ONE_MINUS_SRC_ALPHA);
		fondo2.setBlendFunction(GLES20.GL_SRC_ALPHA,GLES20.GL_ONE_MINUS_SRC_ALPHA);
		titulo.setBlendFunction(GLES20.GL_SRC_ALPHA,GLES20.GL_ONE_MINUS_SRC_ALPHA);
		barrita1.setAlpha(0);
		barrita2.setAlpha(0);
		barrita3.setAlpha(0);
		mundo.setAlpha(0);
		fondo1.setAlpha(0);
		titulo.setAlpha(0);
		//subtitulo.setAlpha(0);
		//titulo.setScale(0.7f);
		
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
							/*barrita1.setAlpha(1);
							barrita2.setAlpha(1);
							barrita3.setAlpha(1);*/
							titulo.registerEntityModifier(new AlphaModifier(0.3f,0,1));
							animacionesBarras(barrita1);
						}},
						new SequenceEntityModifier(
								 
								new DelayModifier(2),
								new AlphaModifier(2f,0,1),
								new DelayModifier(2)

								//,new DelayModifier(2)
								
								
								//,new DelayModifier(0.5f)
								)
				);
		
		mundo.registerEntityModifier(entityModifier);
		fondo1.registerEntityModifier(entityModifier.deepCopy());
		
		barrita1.registerEntityModifier(entityModifier.deepCopy());
		barrita2.registerEntityModifier(entityModifier.deepCopy());
		barrita3.registerEntityModifier(entityModifier.deepCopy());
		mundo.registerEntityModifier(new RotationByModifier(50, 360));
		//titulo.registerEntityModifier(new AlphaModifier(1.5f,0,1));
		escena.attachChild(boton1);
		escena.attachChild(boton2);
		escena.attachChild(boton3);
		escena.attachChild(boton4);
		//item1.setVisible(false);
		//item2.setVisible(false);
		//item3.setVisible(false);
		//item4.setVisible(false);
		//item1.setScale(0.5f);
		//item2.setScale(0.5f);
		//item3.setScale(0.5f);
		//item4.setScale(0.5f);
		boton5.setScale(0.7f);
		boton6.setScale(0.7f);
		boton7.setScale(0.7f);
		boton5.setVisible(false);
		boton6.setVisible(false);
		boton7.setVisible(false);
		item1.setAlpha(0);
		item2.setAlpha(0);
		item3.setAlpha(0);
		item4.setAlpha(0);
		escena.registerTouchArea(boton1);
		escena.registerTouchArea(boton2);
		escena.registerTouchArea(boton3);
		escena.registerTouchArea(boton4);
		escena.registerTouchArea(boton5);
		escena.registerTouchArea(boton6);
		escena.registerTouchArea(boton7);
		
		creditos = new Sprite(0,0,this.tcredit,this.getVertexBufferObjectManager()){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {

				if(pSceneTouchEvent.isActionUp() && creditos.getAlpha()==1){
					
                   creditos.registerEntityModifier(new AlphaModifier(0.5f,1,0));
						
				}
				return false;
			}
		};
		escena.attachChild(creditos);
		escena.attachChild(mundo);
		creditos.setAlpha(0);
		escena.registerTouchArea(creditos);
		return escena;
	}
	public void animacionesBarras(final Sprite b){
		int del=0;
		switch(n){
		case 1:
			pos=638;      
			break;
			
		case 2:
			pos=618;
			break;
			
		case 3:
			del=2;
			pos=598;
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
								n=0;
								pos=-40;
								fondo2.setVisible(true);
								boton5.setVisible(true);
								boton6.setVisible(true);
								boton7.setVisible(true);
								fondo1.registerEntityModifier(new AlphaModifier(2.5f,1,0));
								titulo.registerEntityModifier(new AlphaModifier(0.5f,1,0));
								barrita1.registerEntityModifier(new AlphaModifier(0.2f,1,0));
								barrita2.registerEntityModifier(new AlphaModifier(0.2f,1,0));
								barrita3.registerEntityModifier(new AlphaModifier(0.2f,1,0));
								barrita1.registerEntityModifier(new ScaleModifier(0.2f,1,0));
								barrita2.registerEntityModifier(new ScaleModifier(0.2f,1,0));
								barrita3.registerEntityModifier(new ScaleModifier(0.2f,1,0));
								fondo2.registerEntityModifier(new AlphaModifier(1f,0,1));
								boton5.registerEntityModifier(new AlphaModifier(1f,0,1));
								boton6.registerEntityModifier(new AlphaModifier(1f,0,1));
								boton7.registerEntityModifier(new AlphaModifier(1f,0,1));
								animacionesBotones(boton1);
								break;
							
							}
							
							
							
						}},
						new SequenceEntityModifier(
								new MoveModifier(0.7f, b.getX(), b.getX(), b.getY(), pos, EaseCircularOut.getInstance()),
								new DelayModifier(del)
								)
				);
		b.registerEntityModifier(barrita);
		b.registerEntityModifier(new ScaleModifier(0.5f,0,1));
	}
	public void animacionesBotones(final AnimatedSprite b){
		int del=2;
		switch(n){
		case 1:
			del=0;
			pos=-40;
			break;
			
		case 2:
			del=0;
			pos=(int)530-tbotones.getWidth();
			break;
		case 3:
			del=0;
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
							case 0:
								n++;
								
								//item1.setVisible(true);
								item1.registerEntityModifier(new AlphaModifier(1f,0,1));
								animacionesBotones(boton2);
								break;
								
							case 1:
								//item2.setVisible(true);
								item2.registerEntityModifier(new AlphaModifier(1f,0,1));
								n++;
								animacionesBotones(boton3);
								break;
								
							case 2:
								n++;
								//item3.setVisible(true);
								item3.registerEntityModifier(new AlphaModifier(1f,0,1));
								animacionesBotones(boton4);
								
							case 3:
								//item4.setVisible(true);
								item4.registerEntityModifier(new AlphaModifier(1f,0,1));
								
								/*fondo2.setVisible(true);
								fondo1.registerEntityModifier(new AlphaModifier(2.5f,1,0));
								titulo.registerEntityModifier(new AlphaModifier(0.5f,1,0));
								barrita1.registerEntityModifier(new AlphaModifier(0.2f,1,0));
								barrita2.registerEntityModifier(new AlphaModifier(0.2f,1,0));
								barrita3.registerEntityModifier(new AlphaModifier(0.2f,1,0));
								barrita1.registerEntityModifier(new ScaleModifier(0.2f,1,0));
								barrita2.registerEntityModifier(new ScaleModifier(0.2f,1,0));
								barrita3.registerEntityModifier(new ScaleModifier(0.2f,1,0));
								fondo2.registerEntityModifier(new AlphaModifier(1f,0,1));*/
								break;							
							}
						}},
						new SequenceEntityModifier(
								new DelayModifier(del),
								new MoveModifier(0.5f, b.getX(), pos, b.getY(), b.getY(), EaseBackOut.getInstance())
								)
				);
		b.registerEntityModifier(barrita);
		
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent TouchEvent) {
		if(TouchEvent.isActionUp()){
			boton1.setCurrentTileIndex(0);
			boton2.setCurrentTileIndex(2);
			boton3.setCurrentTileIndex(4);
			boton4.setCurrentTileIndex(6);
			boton5.setCurrentTileIndex(0);
			boton6.setCurrentTileIndex(1);
			boton7.setCurrentTileIndex(2);
			return true;
		}
		return false;
	}
	@Override
	public void onResumeGame() {
		super.onResumeGame();

	
	}

	@Override
	public void onPauseGame() {
		super.onPauseGame();

	
	}
}
	