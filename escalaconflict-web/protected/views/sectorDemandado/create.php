<?php
/* @var $this SectorDemandadoController */
/* @var $model SectorDemandado */

$this->breadcrumbs=array(
	'Sector Demandados'=>array('index'),
	'Create',
);

$this->menu=array(
	array('label'=>'List SectorDemandado', 'url'=>array('index')),
	array('label'=>'Manage SectorDemandado', 'url'=>array('admin')),
);
?>

<h1>Create SectorDemandado</h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>