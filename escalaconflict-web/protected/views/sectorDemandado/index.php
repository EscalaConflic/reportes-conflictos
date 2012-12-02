<?php
/* @var $this SectorDemandadoController */
/* @var $dataProvider CActiveDataProvider */

$this->breadcrumbs=array(
	'Sector Demandados',
);

$this->menu=array(
	array('label'=>'Create SectorDemandado', 'url'=>array('create')),
	array('label'=>'Manage SectorDemandado', 'url'=>array('admin')),
);
?>

<h1>Sector Demandados</h1>

<?php $this->widget('zii.widgets.CListView', array(
	'dataProvider'=>$dataProvider,
	'itemView'=>'_view',
)); ?>
