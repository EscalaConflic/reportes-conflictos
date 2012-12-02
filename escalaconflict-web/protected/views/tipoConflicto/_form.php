<?php
/* @var $this TipoConflictoController */
/* @var $model TipoConflicto */
/* @var $form CActiveForm */
?>

<div class="form">

<?php $form=$this->beginWidget('CActiveForm', array(
	'id'=>'tipo-conflicto-form',
	'enableAjaxValidation'=>false,
)); ?>

	<p class="note">Fields with <span class="required">*</span> are required.</p>

	<?php echo $form->errorSummary($model); ?>

	<div class="row">
		<?php echo $form->labelEx($model,'tblCampoConflicto_id'); ?>                
		<?php //echo $form->textField($model,'tblCampoConflicto_id'); ?>
                <?php 
                    $this->widget('EJuiAutoCompleteFkField', array(
                        'model'=>$model,
                        'attribute'=>'tblCampoConflicto_id',
                        'sourceUrl'=>Yii::app()->createUrl('/campoConflicto/getCampos'),
                        'showFKField'=>true,
                        'relName'=>'tblCampoConflicto',
                        'displayAttr'=>'cc_nombre',
                        'autoCompleteLength'=>60,                        
                        
                    )                           
                    );
                ?>
		<?php echo $form->error($model,'tblCampoConflicto_id'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'tp_nombre'); ?>
		<?php echo $form->textField($model,'tp_nombre',array('size'=>60,'maxlength'=>200)); ?>
		<?php echo $form->error($model,'tp_nombre'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'tp_descripcion'); ?>
		<?php echo $form->textArea($model,'tp_descripcion',array('rows'=>6, 'cols'=>50)); ?>
		<?php echo $form->error($model,'tp_descripcion'); ?>
	</div>

	<div class="row buttons">
		<?php echo CHtml::submitButton($model->isNewRecord ? 'Create' : 'Save'); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- form -->