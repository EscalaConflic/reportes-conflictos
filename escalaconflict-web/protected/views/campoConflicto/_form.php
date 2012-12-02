<?php
/* @var $this CampoConflictoController */
/* @var $model CampoConflicto */
/* @var $form CActiveForm */
?>

<div class="form">

<?php $form=$this->beginWidget('CActiveForm', array(
	'id'=>'campo-conflicto-form',
	'enableAjaxValidation'=>false,
)); ?>

	<p class="note">Fields with <span class="required">*</span> are required.</p>

	<?php echo $form->errorSummary($model); ?>

	<div class="row">
		<?php echo $form->labelEx($model,'cc_nombre'); ?>
		<?php echo $form->textField($model,'cc_nombre',array('size'=>60,'maxlength'=>250)); ?>
		<?php echo $form->error($model,'cc_nombre'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'cc_descripccion'); ?>
		<?php echo $form->textArea($model,'cc_descripccion',array('rows'=>6, 'cols'=>50)); ?>
		<?php echo $form->error($model,'cc_descripccion'); ?>
	</div>

	<div class="row buttons">
		<?php echo CHtml::submitButton($model->isNewRecord ? 'Create' : 'Save'); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- form -->