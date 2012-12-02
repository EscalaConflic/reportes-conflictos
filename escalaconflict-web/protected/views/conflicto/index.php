<?php
/* @var $this ConflictoController */
/* @var $dataProvider CActiveDataProvider */

$this->breadcrumbs=array(
	'Conflictos',
);

$this->menu=array(
	array('label'=>'Create Conflicto', 'url'=>array('create')),
	array('label'=>'Manage Conflicto', 'url'=>array('admin')),
);
?>

<h1>Conflictos</h1>

<?php $this->widget('zii.widgets.CListView', array(
	'dataProvider'=>$dataProvider,
	'itemView'=>'_view',
)); ?>
