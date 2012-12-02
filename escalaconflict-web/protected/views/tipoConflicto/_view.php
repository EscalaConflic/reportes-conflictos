<?php
/* @var $this TipoConflictoController */
/* @var $model TipoConflicto */
?>

<div class="view">

	<b><?php echo CHtml::encode($data->getAttributeLabel('id')); ?>:</b>
	<?php echo CHtml::link(CHtml::encode($data->id), array('view', 'id'=>$data->id)); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('tblCampoConflicto_id')); ?>:</b>
	<?php echo CHtml::encode($data->tblCampoConflicto_id); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('tp_nombre')); ?>:</b>
	<?php echo CHtml::encode($data->tp_nombre); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('tp_descripcion')); ?>:</b>
	<?php echo CHtml::encode($data->tp_descripcion); ?>
	<br />


</div>