<?php
/* @var $this AlcanceController */
/* @var $model Alcance */
?>

<div class="view">

	<b><?php echo CHtml::encode($data->getAttributeLabel('id')); ?>:</b>
	<?php echo CHtml::link(CHtml::encode($data->id), array('view', 'id'=>$data->id)); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('alc_nombre')); ?>:</b>
	<?php echo CHtml::encode($data->alc_nombre); ?>
	<br />


</div>