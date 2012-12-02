<?php
/* @var $this SectorDemandanteController */
/* @var $dataProvider CActiveDataProvider */

$this->breadcrumbs=array(
	'Sector Demandantes',
);

$this->menu=array(
	array('label'=>'Create SectorDemandante', 'url'=>array('create')),
	array('label'=>'Manage SectorDemandante', 'url'=>array('admin')),
);
?>

<h1>Sector Demandantes</h1>

<?php $this->widget('zii.widgets.CListView', array(
	'dataProvider'=>$dataProvider,
	'itemView'=>'_view',
)); ?>
