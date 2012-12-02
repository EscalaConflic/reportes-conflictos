<?php
/* @var $this SectorDemandanteController */
/* @var $model SectorDemandante */

$this->breadcrumbs=array(
	'Sector Demandantes'=>array('index'),
	$model->id,
);

$this->menu=array(
	array('label'=>'List SectorDemandante', 'url'=>array('index')),
	array('label'=>'Create SectorDemandante', 'url'=>array('create')),
	array('label'=>'Update SectorDemandante', 'url'=>array('update', 'id'=>$model->id)),
	array('label'=>'Delete SectorDemandante', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->id),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage SectorDemandante', 'url'=>array('admin')),
);
?>

<h1>View SectorDemandante #<?php echo $model->id; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'id',
		'tblSectores_id',
		'sde_nombre',
	),
)); ?>
