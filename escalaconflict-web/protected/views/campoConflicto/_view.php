<?php
/* @var $this CampoConflictoController */
/* @var $model CampoConflicto */
?>

<div class="view">

	<b><?php echo CHtml::encode($data->getAttributeLabel('id')); ?>:</b>
	<?php echo CHtml::link(CHtml::encode($data->id), array('view', 'id'=>$data->id)); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('cc_nombre')); ?>:</b>
	<?php echo CHtml::encode($data->cc_nombre); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('cc_descripccion')); ?>:</b>
	<?php echo CHtml::encode($data->cc_descripccion); ?>
	<br />


</div>