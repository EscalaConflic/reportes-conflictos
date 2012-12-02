<?php
/* @var $this ConflictoController */
/* @var $model Conflicto */
/* @var $form CActiveForm */
?>

<div class="form">

<?php $form=$this->beginWidget('CActiveForm', array(
	'id'=>'conflicto-form',
	'enableAjaxValidation'=>false,
)); ?>

	<p class="note">Fields with <span class="required">*</span> are required.</p>

	<?php echo $form->errorSummary($model); ?>

	<div class="row">
		<?php echo $form->labelEx($model,'tblTipoConflicto_id'); ?>
		<?php echo $form->textField($model,'tblTipoConflicto_id'); ?>
		<?php echo $form->error($model,'tblTipoConflicto_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'tblSectorDemandado_id'); ?>
		<?php echo $form->textField($model,'tblSectorDemandado_id'); ?>
		<?php echo $form->error($model,'tblSectorDemandado_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'tblSectorDemandante_id'); ?>
		<?php echo $form->textField($model,'tblSectorDemandante_id'); ?>
		<?php echo $form->error($model,'tblSectorDemandante_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'tblUsuarios_id'); ?>
		<?php echo $form->textField($model,'tblUsuarios_id'); ?>
		<?php echo $form->error($model,'tblUsuarios_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'tblUbicacion_id'); ?>
		<?php echo $form->textField($model,'tblUbicacion_id'); ?>
		<?php echo $form->error($model,'tblUbicacion_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'tblAlcance_id'); ?>
		<?php echo $form->textField($model,'tblAlcance_id'); ?>
		<?php echo $form->error($model,'tblAlcance_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'tblAmbito_id'); ?>
		<?php echo $form->textField($model,'tblAmbito_id'); ?>
		<?php echo $form->error($model,'tblAmbito_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'con_medida'); ?>
		<?php echo $form->textField($model,'con_medida',array('size'=>60,'maxlength'=>255)); ?>
		<?php echo $form->error($model,'con_medida'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'con_latitud'); ?>
		<?php echo $form->textField($model,'con_latitud',array('size'=>10,'maxlength'=>10)); ?>
		<?php echo $form->error($model,'con_latitud'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'con_longitud'); ?>
		<?php echo $form->textField($model,'con_longitud',array('size'=>10,'maxlength'=>10)); ?>
		<?php echo $form->error($model,'con_longitud'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'con_fecha'); ?>
		<?php echo $form->textField($model,'con_fecha'); ?>
		<?php echo $form->error($model,'con_fecha'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'con_asunto'); ?>
		<?php echo $form->textField($model,'con_asunto',array('size'=>60,'maxlength'=>255)); ?>
		<?php echo $form->error($model,'con_asunto'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'con_estado'); ?>
		<?php echo $form->textField($model,'con_estado'); ?>
		<?php echo $form->error($model,'con_estado'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'con_salida'); ?>
		<?php echo $form->textField($model,'con_salida',array('size'=>60,'maxlength'=>255)); ?>
		<?php echo $form->error($model,'con_salida'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'con_fuente'); ?>
		<?php echo $form->textField($model,'con_fuente',array('size'=>60,'maxlength'=>255)); ?>
		<?php echo $form->error($model,'con_fuente'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'con_nivel'); ?>
		<?php echo $form->textField($model,'con_nivel'); ?>
		<?php echo $form->error($model,'con_nivel'); ?>
	</div>

	<div class="row buttons">
		<?php echo CHtml::submitButton($model->isNewRecord ? 'Create' : 'Save'); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- form -->