<?php
/* @var $this ConflictoController */
/* @var $model Conflicto */
/* @var $form CActiveForm */
?>

<div class="wide form">

<?php $form=$this->beginWidget('CActiveForm', array(
	'action'=>Yii::app()->createUrl($this->route),
	'method'=>'get',
)); ?>

	<div class="row">
		<?php echo $form->label($model,'id'); ?>
		<?php echo $form->textField($model,'id'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'tblTipoConflicto_id'); ?>
		<?php echo $form->textField($model,'tblTipoConflicto_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'tblSectorDemandado_id'); ?>
		<?php echo $form->textField($model,'tblSectorDemandado_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'tblSectorDemandante_id'); ?>
		<?php echo $form->textField($model,'tblSectorDemandante_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'tblUsuarios_id'); ?>
		<?php echo $form->textField($model,'tblUsuarios_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'tblUbicacion_id'); ?>
		<?php echo $form->textField($model,'tblUbicacion_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'tblAlcance_id'); ?>
		<?php echo $form->textField($model,'tblAlcance_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'tblAmbito_id'); ?>
		<?php echo $form->textField($model,'tblAmbito_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'con_medida'); ?>
		<?php echo $form->textField($model,'con_medida',array('size'=>60,'maxlength'=>255)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'con_latitud'); ?>
		<?php echo $form->textField($model,'con_latitud',array('size'=>10,'maxlength'=>10)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'con_longitud'); ?>
		<?php echo $form->textField($model,'con_longitud',array('size'=>10,'maxlength'=>10)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'con_fecha'); ?>
		<?php echo $form->textField($model,'con_fecha'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'con_asunto'); ?>
		<?php echo $form->textField($model,'con_asunto',array('size'=>60,'maxlength'=>255)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'con_estado'); ?>
		<?php echo $form->textField($model,'con_estado'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'con_salida'); ?>
		<?php echo $form->textField($model,'con_salida',array('size'=>60,'maxlength'=>255)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'con_fuente'); ?>
		<?php echo $form->textField($model,'con_fuente',array('size'=>60,'maxlength'=>255)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'con_nivel'); ?>
		<?php echo $form->textField($model,'con_nivel'); ?>
	</div>

	<div class="row buttons">
		<?php echo CHtml::submitButton('Search'); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->