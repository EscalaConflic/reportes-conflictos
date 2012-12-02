<?php
/* @var $this SectorDemandanteController */
/* @var $model SectorDemandante */
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
		<?php echo $form->label($model,'tblSectores_id'); ?>
		<?php echo $form->textField($model,'tblSectores_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model,'sde_nombre'); ?>
		<?php echo $form->textField($model,'sde_nombre',array('size'=>45,'maxlength'=>45)); ?>
	</div>

	<div class="row buttons">
		<?php echo CHtml::submitButton('Search'); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->