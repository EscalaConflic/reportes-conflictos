<?php
/* @var $this SectorDemandadoController */
/* @var $model SectorDemandado */

$this->breadcrumbs=array(
	'Sector Demandados'=>array('index'),
	$model->id,
);

$this->menu=array(
	array('label'=>'List SectorDemandado', 'url'=>array('index')),
	array('label'=>'Create SectorDemandado', 'url'=>array('create')),
	array('label'=>'Update SectorDemandado', 'url'=>array('update', 'id'=>$model->id)),
	array('label'=>'Delete SectorDemandado', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->id),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage SectorDemandado', 'url'=>array('admin')),
);
?>

<h1>View SectorDemandado #<?php echo $model->id; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'id',
		'tblSectores_id',
		'sdo_nombre',
	),
)); ?>
