<?php
/* @var $this SectorDemandadoController */
/* @var $model SectorDemandado */
?>

<div class="view">

	<b><?php echo CHtml::encode($data->getAttributeLabel('id')); ?>:</b>
	<?php echo CHtml::link(CHtml::encode($data->id), array('view', 'id'=>$data->id)); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('tblSectores_id')); ?>:</b>
	<?php echo CHtml::encode($data->tblSectores_id); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('sdo_nombre')); ?>:</b>
	<?php echo CHtml::encode($data->sdo_nombre); ?>
	<br />


</div>