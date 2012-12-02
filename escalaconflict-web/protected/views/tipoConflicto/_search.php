<?php
/* @var $this TipoConflictoController */
/* @var $model TipoConflicto */
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
		<?php echo $form->label($model,'tblCampoConflicto_id'); ?>
		<?php echo $form->textField($model,'tblCampoConflicto_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'tp_nombre'); ?>
		<?php echo $form->textField($model,'tp_nombre',array('size'=>60,'maxlength'=>200)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'tp_descripcion'); ?>
		<?php echo $form->textArea($model,'tp_descripcion',array('rows'=>6, 'cols'=>50)); ?>
	</div>

	<div class="row buttons">
		<?php echo CHtml::submitButton('Search'); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->