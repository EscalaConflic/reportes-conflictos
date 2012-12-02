<?php
/* @var $this SiteController */
Yii::app()->getClientScript()->registerScriptFile(Yii::app()->baseUrl . '/assets/5175a106/jquery.js');
Yii::app()->getClientScript()->registerScriptFile(Yii::app()->baseUrl . '/assets/5175a106/jquery.tools.min.js');
$this->pageTitle = Yii::app()->name;
?>
<div id="caja_ims" class="round">
    <div id="img_text" class="round">
        <?php //foreach($nuevos as $fil){?> 
        <div class="size_img" style="display: none;">
            <div class="img_der">
                <img src="<?php echo Yii::app()->request->baseUrl; ?>/images/00-03.png" alt="-"/>
            </div>
        </div>
        <div class="size_img" style="display: none;">
            <div class="img_der">
                <img src="<?php echo Yii::app()->request->baseUrl; ?>/images/00-04.png" alt="-"/>
            </div>
        </div>
        <div class="size_img" style="display: none;">
            <div class="img_der">
                <img src="<?php echo Yii::app()->request->baseUrl; ?>/images/00-05.png" alt="-"/>
            </div>
        </div>
        <div class="size_img" style="display: none;">
            <div class="img_der">
                <img src="<?php echo Yii::app()->request->baseUrl; ?>/images/00-06.png" alt="-"/>
            </div>
        </div>
        <div class="size_img" style="display: none;">
            <div class="img_der">
                <img src="<?php echo Yii::app()->request->baseUrl; ?>/images/00-07.png" alt="-"/>
            </div>
        </div>
        <div class="size_img" style="display: none;">
            <div class="img_der">
                <img src="<?php echo Yii::app()->request->baseUrl; ?>/images/00-08.png" alt="-"/>
            </div>
        </div>
        <?php //}?>
    </div>
    <div id="navi_imgs">
        <div class="navegador">
            <div class="slidetabs">
                <a href="#" class="current"></a>
                <a href="#" class=""></a>
                <a href="#" class=""></a>
                <a href="#" class=""></a>
                <a href="#" class=""></a>
                <a href="#" class=""></a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    //var dd=jQuery.noConflict();
    jQuery(document).ready(function(){
        jQuery(".slidetabs").tabs("#img_text > div", {
            effect: 'fade',
            fadeOutSpeed: "slow",
            rotate: true
        }).slideshow().data("slideshow").play();
    });
</script>