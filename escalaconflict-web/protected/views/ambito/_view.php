<?php
/* @var $this AmbitoController */
/* @var $model Ambito */
?>

<div class="view">

	<b><?php echo CHtml::encode($data->getAttributeLabel('id')); ?>:</b>
	<?php echo CHtml::link(CHtml::encode($data->id), array('view', 'id'=>$data->id)); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('amb_nombre')); ?>:</b>
	<?php echo CHtml::encode($data->amb_nombre); ?>
	<br />


</div>