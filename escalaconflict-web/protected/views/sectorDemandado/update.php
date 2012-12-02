<?php
/* @var $this SectorDemandadoController */
/* @var $model SectorDemandado */

$this->breadcrumbs=array(
	'Sector Demandados'=>array('index'),
	$model->id=>array('view','id'=>$model->id),
	'Update',
);

$this->menu=array(
	array('label'=>'List SectorDemandado', 'url'=>array('index')),
	array('label'=>'Create SectorDemandado', 'url'=>array('create')),
	array('label'=>'View SectorDemandado', 'url'=>array('view', 'id'=>$model->id)),
	array('label'=>'Manage SectorDemandado', 'url'=>array('admin')),
);
?>

<h1>Update SectorDemandado <?php echo $model->id; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>