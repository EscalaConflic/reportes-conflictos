<?php
/* @var $this SectorDemandanteController */
/* @var $model SectorDemandante */

$this->breadcrumbs=array(
	'Sector Demandantes'=>array('index'),
	'Create',
);

$this->menu=array(
	array('label'=>'List SectorDemandante', 'url'=>array('index')),
	array('label'=>'Manage SectorDemandante', 'url'=>array('admin')),
);
?>

<h1>Create SectorDemandante</h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>