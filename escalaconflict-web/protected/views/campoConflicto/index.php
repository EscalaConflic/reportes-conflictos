<?php
/* @var $this CampoConflictoController */
/* @var $dataProvider CActiveDataProvider */

$this->breadcrumbs=array(
	'Campo Conflictos',
);

$this->menu=array(
	array('label'=>'Create CampoConflicto', 'url'=>array('create')),
	array('label'=>'Manage CampoConflicto', 'url'=>array('admin')),
);
?>

<h1>Campo Conflictos</h1>

<?php $this->widget('zii.widgets.CListView', array(
	'dataProvider'=>$dataProvider,
	'itemView'=>'_view',
)); ?>
