<?php
/* @var $this SectorDemandanteController */
/* @var $model SectorDemandante */

$this->breadcrumbs=array(
	'Sector Demandantes'=>array('index'),
	$model->id=>array('view','id'=>$model->id),
	'Update',
);

$this->menu=array(
	array('label'=>'List SectorDemandante', 'url'=>array('index')),
	array('label'=>'Create SectorDemandante', 'url'=>array('create')),
	array('label'=>'View SectorDemandante', 'url'=>array('view', 'id'=>$model->id)),
	array('label'=>'Manage SectorDemandante', 'url'=>array('admin')),
);
?>

<h1>Update SectorDemandante <?php echo $model->id; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>