<?php
/* @var $this ConflictoController */
/* @var $model Conflicto */
?>

<div class="view">

	<b><?php echo CHtml::encode($data->getAttributeLabel('id')); ?>:</b>
	<?php echo CHtml::link(CHtml::encode($data->id), array('view', 'id'=>$data->id)); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('tblTipoConflicto_id')); ?>:</b>
	<?php echo CHtml::encode($data->tblTipoConflicto_id); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('tblSectorDemandado_id')); ?>:</b>
	<?php echo CHtml::encode($data->tblSectorDemandado_id); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('tblSectorDemandante_id')); ?>:</b>
	<?php echo CHtml::encode($data->tblSectorDemandante_id); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('tblUsuarios_id')); ?>:</b>
	<?php echo CHtml::encode($data->tblUsuarios_id); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('tblUbicacion_id')); ?>:</b>
	<?php echo CHtml::encode($data->tblUbicacion_id); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('tblAlcance_id')); ?>:</b>
	<?php echo CHtml::encode($data->tblAlcance_id); ?>
	<br />

	<?php /*
	<b><?php echo CHtml::encode($data->getAttributeLabel('tblAmbito_id')); ?>:</b>
	<?php echo CHtml::encode($data->tblAmbito_id); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('con_medida')); ?>:</b>
	<?php echo CHtml::encode($data->con_medida); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('con_latitud')); ?>:</b>
	<?php echo CHtml::encode($data->con_latitud); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('con_longitud')); ?>:</b>
	<?php echo CHtml::encode($data->con_longitud); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('con_fecha')); ?>:</b>
	<?php echo CHtml::encode($data->con_fecha); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('con_asunto')); ?>:</b>
	<?php echo CHtml::encode($data->con_asunto); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('con_estado')); ?>:</b>
	<?php echo CHtml::encode($data->con_estado); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('con_salida')); ?>:</b>
	<?php echo CHtml::encode($data->con_salida); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('con_fuente')); ?>:</b>
	<?php echo CHtml::encode($data->con_fuente); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('con_nivel')); ?>:</b>
	<?php echo CHtml::encode($data->con_nivel); ?>
	<br />

	*/ ?>

</div>