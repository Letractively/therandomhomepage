/*					effectshelper.js
 *
 *  (c) 2005 Siddique Hameed <siddii@gmail.com>
 *
 *
 *	Last Updated :	12/12/2006
 *  For details, see web site: http://www.TheRandomHomepage.com
 *
/*--------------------------------------------------------------------------*/


var TRANSITION_EFFECT_NONE   = -1;
var TRANSITION_EFFECT_RANDOM =  0;
var TRANSITION_EFFECT_BLINDOWN = 1;
var TRANSITION_EFFECT_HIGHLIGHT = 2;
var TRANSITION_EFFECT_SHAKE = 3;
var TRANSITION_EFFECT_PULSATE = 4;
var TRANSITION_EFFECT_GROW = 5;
var TRANSITION_EFFECT_SLIDEDOWN = 6;


function callBackOnFinish(obj){
		try
		{
		   for(var i in obj.effects){
			 if (!Element.visible(obj.effects[i]['element']))
			 {
				new Effect.Appear(obj.effects[i]['element']);
			 }
		   }			
		}
		catch (e)
		{
		}
    }

function applyEffect(element, effectsConstant){
	switch(effectsConstant){
		case TRANSITION_EFFECT_RANDOM:
			applyEffect(element,getRandomNo(TRANSITION_EFFECT_SLIDEDOWN));
			break;	
		case TRANSITION_EFFECT_BLINDOWN:
			new Effect.BlindDown(element,{afterFinish: callBackOnFinish});
			break;
		case TRANSITION_EFFECT_HIGHLIGHT:
			new Effect.Highlight(element,{afterFinish: callBackOnFinish});
			break;	
		case TRANSITION_EFFECT_SHAKE:
			new Effect.Shake(element,{afterFinish: callBackOnFinish});
			break;
		case TRANSITION_EFFECT_PULSATE:
			new Effect.Pulsate(element,{afterFinish: callBackOnFinish});
			break;
		case TRANSITION_EFFECT_GROW:
			new Effect.Grow(element,{afterFinish: callBackOnFinish});
			break;
		case TRANSITION_EFFECT_SLIDEDOWN:
			new Effect.SlideDown(element,{afterFinish: callBackOnFinish});
			break;
	}
}