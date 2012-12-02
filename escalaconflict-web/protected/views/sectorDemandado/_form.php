<?php
/* @var $this SectorDemandadoController */
/* @var $model SectorDemandado */
/* @var $form CActiveForm */
?>

<div class="form">

<?php $form=$this->beginWidget('CActiveForm', array(
	'id'=>'sector-demandado-form',
	'enableAjaxValidation'=>false,
)); ?>

	<p class="note">Fields with <span class="required">*</span> are required.</p>

	<?php echo $form->errorSummary($model); ?>

	<div class="row">
		<?php echo $form->labelEx($model,'tblSectores_id'); ?>
		<?php echo $form->textField($model,'tblSectores_id'); ?>
		<?php echo $form->error($model,'tblSectores_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'sdo_nombre'); ?>
		<?php echo $form->textField($model,'sdo_nombre',array('size'=>45,'maxlength'=>45)); ?>
		<?php echo $form->error($model,'sdo_nombre'); ?>
	</div>

	<div class="row buttons">
		<?php echo CHtml::submitButton($model->isNewRecord ? 'Create' : 'Save'); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- form -->