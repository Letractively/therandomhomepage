<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Random Flickring</title>
<link rel="icon" type="image/png" href="http://www.flickr.com/favicon.ico"/>
<meta name="author" content="Siddique Hameed"/>
<!--
	Last Updated: 12/12/2006
	Version 0.1
-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="http://www.netvibes.com/api/0.3/style.css"/>
<script type="text/javascript" src="http://www.netvibes.com/api/0.3/emulation.js"></script>
<link rel="stylesheet" type="text/css" href="http://www.netvibes.com/api/0.3/style.css"/>
<style type="text/css">
	img {
		border-style: none;
		cursor: pointer;
	}

	#divRandomFlickrControl {
		cursor: pointer;
		color: darkblue;
		font-weight: bold;
	}

	#divRandomFlickrHeader {
		color: black;
		font-weight: bold;
		text-align: center;
	}
	#divRandomFlickrContent {
		text-align: center;
	}
</style>
<script type="text/javascript">
<![CDATA[
// Copyright (c) 2005 Thomas Fuchs (http://script.aculo.us, http://mir.aculo.us)
// Contributors:
//  Justin Palmer (http://encytemedia.com/)
//  Mark Pilgrim (http://diveintomark.org/)
//  Martin Bialasinki
//
// See scriptaculous.js for full license.

/* ------------- element ext -------------- */

// converts rgb() and #xxx to #xxxxxx format,
// returns self (or first argument) if not convertable
String.prototype.parseColor = function() {
  var color = '#';
  if(this.slice(0,4) == 'rgb(') {
    var cols = this.slice(4,this.length-1).split(',');
    var i=0; do { color += parseInt(cols[i]).toColorPart() } while (++i<3);
  } else {
    if(this.slice(0,1) == '#') {
      if(this.length==4) for(var i=1;i<4;i++) color += (this.charAt(i) + this.charAt(i)).toLowerCase();
      if(this.length==7) color = this.toLowerCase();
    }
  }
  return(color.length==7 ? color : (arguments[0] || this));
}

Element.collectTextNodes = function(element) {
  return $A($(element).childNodes).collect( function(node) {
    return (node.nodeType==3 ? node.nodeValue :
      (node.hasChildNodes() ? Element.collectTextNodes(node) : ''));
  }).flatten().join('');
}

Element.collectTextNodesIgnoreClass = function(element, className) {
  return $A($(element).childNodes).collect( function(node) {
    return (node.nodeType==3 ? node.nodeValue :
      ((node.hasChildNodes() && !Element.hasClassName(node,className)) ?
        Element.collectTextNodes(node) : ''));
  }).flatten().join('');
}

Element.setStyle = function(element, style) {
  element = $(element);
  for(k in style) element.style[k.camelize()] = style[k];
}

Element.setContentZoom = function(element, percent) {
  Element.setStyle(element, {fontSize: (percent/100) + 'em'});
  if(navigator.appVersion.indexOf('AppleWebKit')>0) window.scrollBy(0,0);
}

Element.getOpacity = function(element){
  var opacity;
  if (opacity = Element.getStyle(element, 'opacity'))
    return parseFloat(opacity);
  if (opacity = (Element.getStyle(element, 'filter') || '').match(/alpha\(opacity=(.*)\)/))
    if(opacity[1]) return parseFloat(opacity[1]) / 100;
  return 1.0;
}

Element.setOpacity = function(element, value){
  element= $(element);
  if (value == 1){
    Element.setStyle(element, { opacity:
      (/Gecko/.test(navigator.userAgent) && !/Konqueror|Safari|KHTML/.test(navigator.userAgent)) ?
      0.999999 : null });
    if(/MSIE/.test(navigator.userAgent))
      Element.setStyle(element, {filter: Element.getStyle(element,'filter').replace(/alpha\([^\)]*\)/gi,'')});
  } else {
    if(value < 0.00001) value = 0;
    Element.setStyle(element, {opacity: value});
    if(/MSIE/.test(navigator.userAgent))
     Element.setStyle(element,
       { filter: Element.getStyle(element,'filter').replace(/alpha\([^\)]*\)/gi,'') +
                 'alpha(opacity='+value*100+')' });
  }
}

Element.getInlineOpacity = function(element){
  return $(element).style.opacity || '';
}

Element.childrenWithClassName = function(element, className) {
  return $A($(element).getElementsByTagName('*')).select(
    function(c) { return Element.hasClassName(c, className) });
}

Array.prototype.call = function() {
  var args = arguments;
  this.each(function(f){ f.apply(this, args) });
}

/*--------------------------------------------------------------------------*/

var Effect = {
  tagifyText: function(element) {
    var tagifyStyle = 'position:relative';
    if(/MSIE/.test(navigator.userAgent)) tagifyStyle += ';zoom:1';
    element = $(element);
    $A(element.childNodes).each( function(child) {
      if(child.nodeType==3) {
        child.nodeValue.toArray().each( function(character) {
          element.insertBefore(
            Builder.node('span',{style: tagifyStyle},
              character == ' ' ? String.fromCharCode(160) : character),
              child);
        });
        Element.remove(child);
      }
    });
  },
  multiple: function(element, effect) {
    var elements;
    if(((typeof element == 'object') ||
        (typeof element == 'function')) &&
       (element.length))
      elements = element;
    else
      elements = $(element).childNodes;

    var options = Object.extend({
      speed: 0.1,
      delay: 0.0
    }, arguments[2] || {});
    var masterDelay = options.delay;

    $A(elements).each( function(element, index) {
      new effect(element, Object.extend(options, { delay: index * options.speed + masterDelay }));
    });
  },
  PAIRS: {
    'slide':  ['SlideDown','SlideUp'],
    'blind':  ['BlindDown','BlindUp'],
    'appear': ['Appear','Fade']
  },
  toggle: function(element, effect) {
    element = $(element);
    effect = (effect || 'appear').toLowerCase();
    var options = Object.extend({
      queue: { position:'end', scope:(element.id || 'global') }
    }, arguments[2] || {});
    Effect[Element.visible(element) ?
      Effect.PAIRS[effect][1] : Effect.PAIRS[effect][0]](element, options);
  }
};

var Effect2 = Effect; // deprecated

/* ------------- transitions ------------- */

Effect.Transitions = {}

Effect.Transitions.linear = function(pos) {
  return pos;
}
Effect.Transitions.sinoidal = function(pos) {
  return (-Math.cos(pos*Math.PI)/2) + 0.5;
}
Effect.Transitions.reverse  = function(pos) {
  return 1-pos;
}
Effect.Transitions.flicker = function(pos) {
  return ((-Math.cos(pos*Math.PI)/4) + 0.75) + Math.random()/4;
}
Effect.Transitions.wobble = function(pos) {
  return (-Math.cos(pos*Math.PI*(9*pos))/2) + 0.5;
}
Effect.Transitions.pulse = function(pos) {
  return (Math.floor(pos*10) % 2 == 0 ?
    (pos*10-Math.floor(pos*10)) : 1-(pos*10-Math.floor(pos*10)));
}
Effect.Transitions.none = function(pos) {
  return 0;
}
Effect.Transitions.full = function(pos) {
  return 1;
}

/* ------------- core effects ------------- */

Effect.ScopedQueue = Class.create();
Object.extend(Object.extend(Effect.ScopedQueue.prototype, Enumerable), {
  initialize: function() {
    this.effects  = [];
    this.interval = null;
  },
  _each: function(iterator) {
    this.effects._each(iterator);
  },
  add: function(effect) {
    var timestamp = new Date().getTime();

    var position = (typeof effect.options.queue == 'string') ?
      effect.options.queue : effect.options.queue.position;

    switch(position) {
      case 'front':
        // move unstarted effects after this effect
        this.effects.findAll(function(e){ return e.state=='idle' }).each( function(e) {
            e.startOn  += effect.finishOn;
            e.finishOn += effect.finishOn;
          });
        break;
      case 'end':
        // start effect after last queued effect has finished
        timestamp = this.effects.pluck('finishOn').max() || timestamp;
        break;
    }

    effect.startOn  += timestamp;
    effect.finishOn += timestamp;
    this.effects.push(effect);
    if(!this.interval)
      this.interval = setInterval(this.loop.bind(this), 40);
  },
  remove: function(effect) {
    this.effects = this.effects.reject(function(e) { return e==effect });
    if(this.effects.length == 0) {
      clearInterval(this.interval);
      this.interval = null;
    }
  },
  loop: function() {
    var timePos = new Date().getTime();
    this.effects.invoke('loop', timePos);
  }
});

Effect.Queues = {
  instances: $H(),
  get: function(queueName) {
    if(typeof queueName != 'string') return queueName;

    if(!this.instances[queueName])
      this.instances[queueName] = new Effect.ScopedQueue();

    return this.instances[queueName];
  }
}
Effect.Queue = Effect.Queues.get('global');

Effect.DefaultOptions = {
  transition: Effect.Transitions.sinoidal,
  duration:   1.0,   // seconds
  fps:        25.0,  // max. 25fps due to Effect.Queue implementation
  sync:       false, // true for combining
  from:       0.0,
  to:         1.0,
  delay:      0.0,
  queue:      'parallel'
}

Effect.Base = function() {};
Effect.Base.prototype = {
  position: null,
  start: function(options) {
    this.options      = Object.extend(Object.extend({},Effect.DefaultOptions), options || {});
    this.currentFrame = 0;
    this.state        = 'idle';
    this.startOn      = this.options.delay*1000;
    this.finishOn     = this.startOn + (this.options.duration*1000);
    this.event('beforeStart');
    if(!this.options.sync)
      Effect.Queues.get(typeof this.options.queue == 'string' ?
        'global' : this.options.queue.scope).add(this);
  },
  loop: function(timePos) {
    if(timePos >= this.startOn) {
      if(timePos >= this.finishOn) {
        this.render(1.0);
        this.cancel();
        this.event('beforeFinish');
        if(this.finish) this.finish();
        this.event('afterFinish');
        return;
      }
      var pos   = (timePos - this.startOn) / (this.finishOn - this.startOn);
      var frame = Math.round(pos * this.options.fps * this.options.duration);
      if(frame > this.currentFrame) {
        this.render(pos);
        this.currentFrame = frame;
      }
    }
  },
  render: function(pos) {
    if(this.state == 'idle') {
      this.state = 'running';
      this.event('beforeSetup');
      if(this.setup) this.setup();
      this.event('afterSetup');
    }
    if(this.state == 'running') {
      if(this.options.transition) pos = this.options.transition(pos);
      pos *= (this.options.to-this.options.from);
      pos += this.options.from;
      this.position = pos;
      this.event('beforeUpdate');
      if(this.update) this.update(pos);
      this.event('afterUpdate');
    }
  },
  cancel: function() {
    if(!this.options.sync)
      Effect.Queues.get(typeof this.options.queue == 'string' ?
        'global' : this.options.queue.scope).remove(this);
    this.state = 'finished';
  },
  event: function(eventName) {
    if(this.options[eventName + 'Internal']) this.options[eventName + 'Internal'](this);
    if(this.options[eventName]) this.options[eventName](this);
  },
  inspect: function() {
    return '#<Effect:' + $H(this).inspect() + ',options:' + $H(this.options).inspect() + '>';
  }
}

Effect.Parallel = Class.create();
Object.extend(Object.extend(Effect.Parallel.prototype, Effect.Base.prototype), {
  initialize: function(effects) {
    this.effects = effects || [];
    this.start(arguments[1]);
  },
  update: function(position) {
    this.effects.invoke('render', position);
  },
  finish: function(position) {
    this.effects.each( function(effect) {
      effect.render(1.0);
      effect.cancel();
      effect.event('beforeFinish');
      if(effect.finish) effect.finish(position);
      effect.event('afterFinish');
    });
  }
});

Effect.Opacity = Class.create();
Object.extend(Object.extend(Effect.Opacity.prototype, Effect.Base.prototype), {
  initialize: function(element) {
    this.element = $(element);
    // make this work on IE on elements without 'layout'
    if(/MSIE/.test(navigator.userAgent) && (!this.element.hasLayout))
      Element.setStyle(this.element, {zoom: 1});
    var options = Object.extend({
      from: Element.getOpacity(this.element) || 0.0,
      to:   1.0
    }, arguments[1] || {});
    this.start(options);
  },
  update: function(position) {
    Element.setOpacity(this.element, position);
  }
});

Effect.Move = Class.create();
Object.extend(Object.extend(Effect.Move.prototype, Effect.Base.prototype), {
  initialize: function(element) {
    this.element = $(element);
    var options = Object.extend({
      x:    0,
      y:    0,
      mode: 'relative'
    }, arguments[1] || {});
    this.start(options);
  },
  setup: function() {
    // Bug in Opera: Opera returns the "real" position of a static element or
    // relative element that does not have top/left explicitly set.
    // ==> Always set top and left for position relative elements in your stylesheets
    // (to 0 if you do not need them)
    Element.makePositioned(this.element);
    this.originalLeft = parseFloat(Element.getStyle(this.element,'left') || '0');
    this.originalTop  = parseFloat(Element.getStyle(this.element,'top')  || '0');
    if(this.options.mode == 'absolute') {
      // absolute movement, so we need to calc deltaX and deltaY
      this.options.x = this.options.x - this.originalLeft;
      this.options.y = this.options.y - this.originalTop;
    }
  },
  update: function(position) {
    Element.setStyle(this.element, {
      left: this.options.x  * position + this.originalLeft + 'px',
      top:  this.options.y  * position + this.originalTop  + 'px'
    });
  }
});

// for backwards compatibility
Effect.MoveBy = function(element, toTop, toLeft) {
  return new Effect.Move(element,
    Object.extend({ x: toLeft, y: toTop }, arguments[3] || {}));
};

Effect.Scale = Class.create();
Object.extend(Object.extend(Effect.Scale.prototype, Effect.Base.prototype), {
  initialize: function(element, percent) {
    this.element = $(element)
    var options = Object.extend({
      scaleX: true,
      scaleY: true,
      scaleContent: true,
      scaleFromCenter: false,
      scaleMode: 'box',        // 'box' or 'contents' or {} with provided values
      scaleFrom: 100.0,
      scaleTo:   percent
    }, arguments[2] || {});
    this.start(options);
  },
  setup: function() {
    this.restoreAfterFinish = this.options.restoreAfterFinish || false;
    this.elementPositioning = Element.getStyle(this.element,'position');

    this.originalStyle = {};
    ['top','left','width','height','fontSize'].each( function(k) {
      this.originalStyle[k] = this.element.style[k];
    }.bind(this));

    this.originalTop  = this.element.offsetTop;
    this.originalLeft = this.element.offsetLeft;

    var fontSize = Element.getStyle(this.element,'font-size') || '100%';
    ['em','px','%'].each( function(fontSizeType) {
      if(fontSize.indexOf(fontSizeType)>0) {
        this.fontSize     = parseFloat(fontSize);
        this.fontSizeType = fontSizeType;
      }
    }.bind(this));

    this.factor = (this.options.scaleTo - this.options.scaleFrom)/100;

    this.dims = null;
    if(this.options.scaleMode=='box')
      this.dims = [this.element.offsetHeight, this.element.offsetWidth];
    if(/^content/.test(this.options.scaleMode))
      this.dims = [this.element.scrollHeight, this.element.scrollWidth];
    if(!this.dims)
      this.dims = [this.options.scaleMode.originalHeight,
                   this.options.scaleMode.originalWidth];
  },
  update: function(position) {
    var currentScale = (this.options.scaleFrom/100.0) + (this.factor * position);
    if(this.options.scaleContent && this.fontSize)
      Element.setStyle(this.element, {fontSize: this.fontSize * currentScale + this.fontSizeType });
    this.setDimensions(this.dims[0] * currentScale, this.dims[1] * currentScale);
  },
  finish: function(position) {
    if (this.restoreAfterFinish) Element.setStyle(this.element, this.originalStyle);
  },
  setDimensions: function(height, width) {
    var d = {};
    if(this.options.scaleX) d.width = width + 'px';
    if(this.options.scaleY) d.height = height + 'px';
    if(this.options.scaleFromCenter) {
      var topd  = (height - this.dims[0])/2;
      var leftd = (width  - this.dims[1])/2;
      if(this.elementPositioning == 'absolute') {
        if(this.options.scaleY) d.top = this.originalTop-topd + 'px';
        if(this.options.scaleX) d.left = this.originalLeft-leftd + 'px';
      } else {
        if(this.options.scaleY) d.top = -topd + 'px';
        if(this.options.scaleX) d.left = -leftd + 'px';
      }
    }
    Element.setStyle(this.element, d);
  }
});

Effect.Highlight = Class.create();
Object.extend(Object.extend(Effect.Highlight.prototype, Effect.Base.prototype), {
  initialize: function(element) {
    this.element = $(element);
    var options = Object.extend({ startcolor: '#ffff99' }, arguments[1] || {});
    this.start(options);
  },
  setup: function() {
    // Prevent executing on elements not in the layout flow
    if(Element.getStyle(this.element, 'display')=='none') { this.cancel(); return; }
    // Disable background image during the effect
    this.oldStyle = {
      backgroundImage: Element.getStyle(this.element, 'background-image') };
    Element.setStyle(this.element, {backgroundImage: 'none'});
    if(!this.options.endcolor)
      this.options.endcolor = Element.getStyle(this.element, 'background-color').parseColor('#ffffff');
    if(!this.options.restorecolor)
      this.options.restorecolor = Element.getStyle(this.element, 'background-color');
    // init color calculations
    this._base  = $R(0,2).map(function(i){ return parseInt(this.options.startcolor.slice(i*2+1,i*2+3),16) }.bind(this));
    this._delta = $R(0,2).map(function(i){ return parseInt(this.options.endcolor.slice(i*2+1,i*2+3),16)-this._base[i] }.bind(this));
  },
  update: function(position) {
    Element.setStyle(this.element,{backgroundColor: $R(0,2).inject('#',function(m,v,i){
      return m+(Math.round(this._base[i]+(this._delta[i]*position)).toColorPart()); }.bind(this)) });
  },
  finish: function() {
    Element.setStyle(this.element, Object.extend(this.oldStyle, {
      backgroundColor: this.options.restorecolor
    }));
  }
});

Effect.ScrollTo = Class.create();
Object.extend(Object.extend(Effect.ScrollTo.prototype, Effect.Base.prototype), {
  initialize: function(element) {
    this.element = $(element);
    this.start(arguments[1] || {});
  },
  setup: function() {
    Position.prepare();
    var offsets = Position.cumulativeOffset(this.element);
    if(this.options.offset) offsets[1] += this.options.offset;
    var max = window.innerHeight ?
      window.height - window.innerHeight :
      document.body.scrollHeight -
        (document.documentElement.clientHeight ?
          document.documentElement.clientHeight : document.body.clientHeight);
    this.scrollStart = Position.deltaY;
    this.delta = (offsets[1] > max ? max : offsets[1]) - this.scrollStart;
  },
  update: function(position) {
    Position.prepare();
    window.scrollTo(Position.deltaX,
      this.scrollStart + (position*this.delta));
  }
});

/* ------------- combination effects ------------- */

Effect.Fade = function(element) {
  var oldOpacity = Element.getInlineOpacity(element);
  var options = Object.extend({
  from: Element.getOpacity(element) || 1.0,
  to:   0.0,
  afterFinishInternal: function(effect) { with(Element) {
    if(effect.options.to!=0) return;
    hide(effect.element);
    setStyle(effect.element, {opacity: oldOpacity}); }}
  }, arguments[1] || {});
  return new Effect.Opacity(element,options);
}

Effect.Appear = function(element) {
  var options = Object.extend({
  from: (Element.getStyle(element, 'display') == 'none' ? 0.0 : Element.getOpacity(element) || 0.0),
  to:   1.0,
  beforeSetup: function(effect) { with(Element) {
    setOpacity(effect.element, effect.options.from);
    show(effect.element); }}
  }, arguments[1] || {});
  return new Effect.Opacity(element,options);
}

Effect.Puff = function(element) {
  element = $(element);
  var oldStyle = { opacity: Element.getInlineOpacity(element), position: Element.getStyle(element, 'position') };
  return new Effect.Parallel(
   [ new Effect.Scale(element, 200,
      { sync: true, scaleFromCenter: true, scaleContent: true, restoreAfterFinish: true }),
     new Effect.Opacity(element, { sync: true, to: 0.0 } ) ],
     Object.extend({ duration: 1.0,
      beforeSetupInternal: function(effect) { with(Element) {
        setStyle(effect.effects[0].element, {position: 'absolute'}); }},
      afterFinishInternal: function(effect) { with(Element) {
         hide(effect.effects[0].element);
         setStyle(effect.effects[0].element, oldStyle); }}
     }, arguments[1] || {})
   );
}

Effect.BlindUp = function(element) {
  element = $(element);
  Element.makeClipping(element);
  return new Effect.Scale(element, 0,
    Object.extend({ scaleContent: false,
      scaleX: false,
      restoreAfterFinish: true,
      afterFinishInternal: function(effect) { with(Element) {
        [hide, undoClipping].call(effect.element); }}
    }, arguments[1] || {})
  );
}

Effect.BlindDown = function(element) {
  element = $(element);
  var oldHeight = Element.getStyle(element, 'height');
  var elementDimensions = Element.getDimensions(element);
  return new Effect.Scale(element, 100,
    Object.extend({ scaleContent: false,
      scaleX: false,
      scaleFrom: 0,
      scaleMode: {originalHeight: elementDimensions.height, originalWidth: elementDimensions.width},
      restoreAfterFinish: true,
      afterSetup: function(effect) { with(Element) {
        makeClipping(effect.element);
        setStyle(effect.element, {height: '0px'});
        show(effect.element);
      }},
      afterFinishInternal: function(effect) { with(Element) {
        undoClipping(effect.element);
        setStyle(effect.element, {height: oldHeight});
      }}
    }, arguments[1] || {})
  );
}

Effect.SwitchOff = function(element) {
  element = $(element);
  var oldOpacity = Element.getInlineOpacity(element);
  return new Effect.Appear(element, {
    duration: 0.4,
    from: 0,
    transition: Effect.Transitions.flicker,
    afterFinishInternal: function(effect) {
      new Effect.Scale(effect.element, 1, {
        duration: 0.3, scaleFromCenter: true,
        scaleX: false, scaleContent: false, restoreAfterFinish: true,
        beforeSetup: function(effect) { with(Element) {
          [makePositioned,makeClipping].call(effect.element);
        }},
        afterFinishInternal: function(effect) { with(Element) {
          [hide,undoClipping,undoPositioned].call(effect.element);
          setStyle(effect.element, {opacity: oldOpacity});
        }}
      })
    }
  });
}

Effect.DropOut = function(element) {
  element = $(element);
  var oldStyle = {
    top: Element.getStyle(element, 'top'),
    left: Element.getStyle(element, 'left'),
    opacity: Element.getInlineOpacity(element) };
  return new Effect.Parallel(
    [ new Effect.Move(element, {x: 0, y: 100, sync: true }),
      new Effect.Opacity(element, { sync: true, to: 0.0 }) ],
    Object.extend(
      { duration: 0.5,
        beforeSetup: function(effect) { with(Element) {
          makePositioned(effect.effects[0].element); }},
        afterFinishInternal: function(effect) { with(Element) {
          [hide, undoPositioned].call(effect.effects[0].element);
          setStyle(effect.effects[0].element, oldStyle); }}
      }, arguments[1] || {}));
}

Effect.Shake = function(element) {
  element = $(element);
  var oldStyle = {
    top: Element.getStyle(element, 'top'),
    left: Element.getStyle(element, 'left') };
	  return new Effect.Move(element,
	    { x:  20, y: 0, duration: 0.05, afterFinishInternal: function(effect) {
	  new Effect.Move(effect.element,
	    { x: -40, y: 0, duration: 0.1,  afterFinishInternal: function(effect) {
	  new Effect.Move(effect.element,
	    { x:  40, y: 0, duration: 0.1,  afterFinishInternal: function(effect) {
	  new Effect.Move(effect.element,
	    { x: -40, y: 0, duration: 0.1,  afterFinishInternal: function(effect) {
	  new Effect.Move(effect.element,
	    { x:  40, y: 0, duration: 0.1,  afterFinishInternal: function(effect) {
	  new Effect.Move(effect.element,
	    { x: -20, y: 0, duration: 0.05, afterFinishInternal: function(effect) { with(Element) {
        undoPositioned(effect.element);
        setStyle(effect.element, oldStyle);
  }}}) }}) }}) }}) }}) }});
}

Effect.SlideDown = function(element) {
  element = $(element);
  Element.cleanWhitespace(element);
  // SlideDown need to have the content of the element wrapped in a container element with fixed height!
  var oldInnerBottom = Element.getStyle(element.firstChild, 'bottom');
  var elementDimensions = Element.getDimensions(element);
  return new Effect.Scale(element, 100, Object.extend({
    scaleContent: false,
    scaleX: false,
    scaleFrom: 0,
    scaleMode: {originalHeight: elementDimensions.height, originalWidth: elementDimensions.width},
    restoreAfterFinish: true,
    afterSetup: function(effect) { with(Element) {
      makePositioned(effect.element);
      makePositioned(effect.element.firstChild);
      if(window.opera) setStyle(effect.element, {top: ''});
      makeClipping(effect.element);
      setStyle(effect.element, {height: '0px'});
      show(element); }},
    afterUpdateInternal: function(effect) { with(Element) {
      setStyle(effect.element.firstChild, {bottom:
        (effect.dims[0] - effect.element.clientHeight) + 'px' }); }},
    afterFinishInternal: function(effect) { with(Element) {
      undoClipping(effect.element);
      undoPositioned(effect.element.firstChild);
      undoPositioned(effect.element);
      setStyle(effect.element.firstChild, {bottom: oldInnerBottom}); }}
    }, arguments[1] || {})
  );
}

Effect.SlideUp = function(element) {
  element = $(element);
  Element.cleanWhitespace(element);
  var oldInnerBottom = Element.getStyle(element.firstChild, 'bottom');
  return new Effect.Scale(element, 0,
   Object.extend({ scaleContent: false,
    scaleX: false,
    scaleMode: 'box',
    scaleFrom: 100,
    restoreAfterFinish: true,
    beforeStartInternal: function(effect) { with(Element) {
      makePositioned(effect.element);
      makePositioned(effect.element.firstChild);
      if(window.opera) setStyle(effect.element, {top: ''});
      makeClipping(effect.element);
      show(element); }},
    afterUpdateInternal: function(effect) { with(Element) {
      setStyle(effect.element.firstChild, {bottom:
        (effect.dims[0] - effect.element.clientHeight) + 'px' }); }},
    afterFinishInternal: function(effect) { with(Element) {
        [hide, undoClipping].call(effect.element);
        undoPositioned(effect.element.firstChild);
        undoPositioned(effect.element);
        setStyle(effect.element.firstChild, {bottom: oldInnerBottom}); }}
   }, arguments[1] || {})
  );
}

// Bug in opera makes the TD containing this element expand for a instance after finish
Effect.Squish = function(element) {
  return new Effect.Scale(element, window.opera ? 1 : 0,
    { restoreAfterFinish: true,
      beforeSetup: function(effect) { with(Element) {
        makeClipping(effect.element); }},
      afterFinishInternal: function(effect) { with(Element) {
        hide(effect.element);
        undoClipping(effect.element); }}
  });
}

Effect.Grow = function(element) {
  element = $(element);
  var options = Object.extend({
    direction: 'center',
    moveTransistion: Effect.Transitions.sinoidal,
    scaleTransition: Effect.Transitions.sinoidal,
    opacityTransition: Effect.Transitions.full
  }, arguments[1] || {});
  var oldStyle = {
    top: element.style.top,
    left: element.style.left,
    height: element.style.height,
    width: element.style.width,
    opacity: Element.getInlineOpacity(element) };

  var dims = Element.getDimensions(element);
  var initialMoveX, initialMoveY;
  var moveX, moveY;

  switch (options.direction) {
    case 'top-left':
      initialMoveX = initialMoveY = moveX = moveY = 0;
      break;
    case 'top-right':
      initialMoveX = dims.width;
      initialMoveY = moveY = 0;
      moveX = -dims.width;
      break;
    case 'bottom-left':
      initialMoveX = moveX = 0;
      initialMoveY = dims.height;
      moveY = -dims.height;
      break;
    case 'bottom-right':
      initialMoveX = dims.width;
      initialMoveY = dims.height;
      moveX = -dims.width;
      moveY = -dims.height;
      break;
    case 'center':
      initialMoveX = dims.width / 2;
      initialMoveY = dims.height / 2;
      moveX = -dims.width / 2;
      moveY = -dims.height / 2;
      break;
  }

  return new Effect.Move(element, {
    x: initialMoveX,
    y: initialMoveY,
    duration: 0.01,
    beforeSetup: function(effect) { with(Element) {
      hide(effect.element);
      makeClipping(effect.element);
      makePositioned(effect.element);
    }},
    afterFinishInternal: function(effect) {
      new Effect.Parallel(
        [ new Effect.Opacity(effect.element, { sync: true, to: 1.0, from: 0.0, transition: options.opacityTransition }),
          new Effect.Move(effect.element, { x: moveX, y: moveY, sync: true, transition: options.moveTransition }),
          new Effect.Scale(effect.element, 100, {
            scaleMode: { originalHeight: dims.height, originalWidth: dims.width },
            sync: true, scaleFrom: window.opera ? 1 : 0, transition: options.scaleTransition, restoreAfterFinish: true})
        ], Object.extend({
             beforeSetup: function(effect) { with(Element) {
               setStyle(effect.effects[0].element, {height: '0px'});
               show(effect.effects[0].element); }},
             afterFinishInternal: function(effect) { with(Element) {
               [undoClipping, undoPositioned].call(effect.effects[0].element);
               setStyle(effect.effects[0].element, oldStyle); }}
           }, options)
      )
    }
  });
}

Effect.Shrink = function(element) {
  element = $(element);
  var options = Object.extend({
    direction: 'center',
    moveTransistion: Effect.Transitions.sinoidal,
    scaleTransition: Effect.Transitions.sinoidal,
    opacityTransition: Effect.Transitions.none
  }, arguments[1] || {});
  var oldStyle = {
    top: element.style.top,
    left: element.style.left,
    height: element.style.height,
    width: element.style.width,
    opacity: Element.getInlineOpacity(element) };

  var dims = Element.getDimensions(element);
  var moveX, moveY;

  switch (options.direction) {
    case 'top-left':
      moveX = moveY = 0;
      break;
    case 'top-right':
      moveX = dims.width;
      moveY = 0;
      break;
    case 'bottom-left':
      moveX = 0;
      moveY = dims.height;
      break;
    case 'bottom-right':
      moveX = dims.width;
      moveY = dims.height;
      break;
    case 'center':
      moveX = dims.width / 2;
      moveY = dims.height / 2;
      break;
  }

  return new Effect.Parallel(
    [ new Effect.Opacity(element, { sync: true, to: 0.0, from: 1.0, transition: options.opacityTransition }),
      new Effect.Scale(element, window.opera ? 1 : 0, { sync: true, transition: options.scaleTransition, restoreAfterFinish: true}),
      new Effect.Move(element, { x: moveX, y: moveY, sync: true, transition: options.moveTransition })
    ], Object.extend({
         beforeStartInternal: function(effect) { with(Element) {
           [makePositioned, makeClipping].call(effect.effects[0].element) }},
         afterFinishInternal: function(effect) { with(Element) {
           [hide, undoClipping, undoPositioned].call(effect.effects[0].element);
           setStyle(effect.effects[0].element, oldStyle); }}
       }, options)
  );
}

Effect.Pulsate = function(element) {
  element = $(element);
  var options    = arguments[1] || {};
  var oldOpacity = Element.getInlineOpacity(element);
  var transition = options.transition || Effect.Transitions.sinoidal;
  var reverser   = function(pos){ return transition(1-Effect.Transitions.pulse(pos)) };
  reverser.bind(transition);
  return new Effect.Opacity(element,
    Object.extend(Object.extend({  duration: 3.0, from: 0,
      afterFinishInternal: function(effect) { Element.setStyle(effect.element, {opacity: oldOpacity}); }
    }, options), {transition: reverser}));
}

Effect.Fold = function(element) {
  element = $(element);
  var oldStyle = {
    top: element.style.top,
    left: element.style.left,
    width: element.style.width,
    height: element.style.height };
  Element.makeClipping(element);
  return new Effect.Scale(element, 5, Object.extend({
    scaleContent: false,
    scaleX: false,
    afterFinishInternal: function(effect) {
    new Effect.Scale(element, 1, {
      scaleContent: false,
      scaleY: false,
      afterFinishInternal: function(effect) { with(Element) {
        [hide, undoClipping].call(effect.element);
        setStyle(effect.element, oldStyle);
      }} });
  }}, arguments[1] || {}));
}
]]>
</script>

<script type="text/javascript">
<![CDATA[
// -----------------------------------------------------------------------------------
//
//	Lightbox v2.02
//	by Lokesh Dhakar - http://www.huddletogether.com
//	3/31/06
//
//	For more information on this script, visit:
//	http://huddletogether.com/projects/lightbox2/
//
//	Licensed under the Creative Commons Attribution 2.5 License - http://creativecommons.org/licenses/by/2.5/
//
//	Credit also due to those who have helped, inspired, and made their code available to the public.
//	Including: Scott Upton(uptonic.com), Peter-Paul Koch(quirksmode.org), Thomas Fuchs(mir.aculo.us), and others.
//
//
// -----------------------------------------------------------------------------------
/*

History of changes by ahavriluk:
07/23/06 - fixed issue with background color being green in FireFox. Made music player appear and hide depending on
				   slideshow play mode.
07/21/06 - added color background support for music player. To change the skin look at createMusicPlayer function.
07/19/06 - added changeImageByTimer() function which helps to load the image while the entire page is loading.
07/17/06 - fixed a bug when slideshow doesn't start if navigation buttons (next/prev) were used first and slideshow=0 at start
	 - added code to remove dotted lines around images-links
	 - added code which suppose to help starting slideshow before a page is totaly loaded
*/

/*

	Table of Contents
	-----------------
	Configuration
	Global Variables

	Extending Built-in Objects
	- Object.extend(Element)
	- Array.prototype.removeDuplicates()
	- Array.prototype.empty()

	Lightbox Class Declaration
	- initialize()
	- start()
	- changeImage()
	- resizeImageContainer()
	- showImage()
	- updateDetails()
	- updateNav()
	- enableKeyboardNav()
	- disableKeyboardNav()
	- keyboardAction()
	- preloadNeighborImages()
	- end()

	Miscellaneous Functions
	- getPageScroll()
	- getPageSize()
	- getKey()
	- listenKey()
	- showSelectBoxes()
	- hideSelectBoxes()
	- pause()
	- initLightbox()

	Function Calls
	- addLoadEvent(initLightbox)

	Slideshow Functions
	- toggleSlideShow()
	- startSlideShow()
	- stopSlideShow()
	- showMusicPlayer()
	- playMusic()
	- stopMusic()



*/
// -----------------------------------------------------------------------------------

//
//	Configuration
//
var musicPlayer = "http://www.therandomhomepage.com/js/playerMini.swf"
var fileLoadingImage = "http://www.therandomhomepage.com/images/lightbox/loading.gif";
var fileBottomNavCloseImage = "http://www.therandomhomepage.com/images/lightbox/close1.gif";
var resizeSpeed = 7;		// controls the speed of the image resizing (1=slowest and 10=fastest)
var borderSize = 10;		//if you adjust the padding in the CSS, you will need to update this variable

//--- Slideshow options
//var slideShowWidth = 600;	// -1 size slideshow window based on each image
//var slideShowHeight = 450;	// -1 size slideshow window based on each image
var slideShowWidth = -1;
var slideShowHeight = -1;
var SlideShowStartImage = "http://www.therandomhomepage.com/images/lightbox/start.gif";	// Slideshow toggle button
var SlideShowStopImage = "http://www.therandomhomepage.com/images/lightbox/stop.gif";
var slideshow = 1;   		// Set 0 if you want to disable slideshows by default
var foreverLoop = 0;		// Set 0 if want to stop on last image or Set 1 for Infinite loop feature
var loopInterval = 3000;	// image swap interval
var resize = 1;// Set 0 to disable auto-resizing
// -----------------------------------------------------------------------------------

//
//	Global Variables
//

var imageArray = new Array;
var activeImage;

if(resizeSpeed > 10){ resizeSpeed = 10;}
if(resizeSpeed < 1){ resizeSpeed = 1;}
resizeDuration = (11 - resizeSpeed) * 0.15;

var so = null;
var objSlideShowImage;
var objLightboxImage;
var objImageDataContainer;

var keyPressed = false;
var slideshowMusic = null;
var firstTime = 1;

var saveSlideshow;
var saveForeverLoop;
var saveLoopInterval;
var saveSlideShowWidth;
var saveSlideShowHeight;
// -----------------------------------------------------------------------------------

//
//	Additional methods for Element added by SU, Couloir
//	- further additions by Lokesh Dhakar (huddletogether.com)
//
Object.extend(Element, {
	getWidth: function(element) {
	   	element = $(element);
	   	return element.offsetWidth;
	},
	setWidth: function(element,w) {
	   	element = $(element);
    	element.style.width = w +"px";
	},
	setHeight: function(element,h) {
   		element = $(element);
    	element.style.height = h +"px";
	},
	setTop: function(element,t) {
	   	element = $(element);
    	element.style.top = t +"px";
	},
	setSrc: function(element,src) {
    	element = $(element);
    	element.src = src;
	},
	setHref: function(element,href) {
    	element = $(element);
    	element.href = href;
	},
	setInnerHTML: function(element,content) {
		element = $(element);
		element.innerHTML = content;
	}
});

// -----------------------------------------------------------------------------------

//
//	Extending built-in Array object
//	- array.removeDuplicates()
//	- array.empty()
//
Array.prototype.removeDuplicates = function () {
	for(i = 1; i < this.length; i++){
		if(this[i][0] == this[i-1][0]){
			this.splice(i,1);
		}
	}
}

// -----------------------------------------------------------------------------------

Array.prototype.empty = function () {
	for(i = 0; i <= this.length; i++){
		this.shift();
	}
}

// -----------------------------------------------------------------------------------

//
//	Lightbox Class Declaration
//	- initialize()
//	- start()
//	- changeImage()
//	- resizeImageContainer()
//	- showImage()
//	- updateDetails()
//	- updateNav()
//	- enableKeyboardNav()
//	- disableKeyboardNav()
//	- keyboardNavAction()
//	- preloadNeighborImages()
//	- end()
//
//	Structuring of code inspired by Scott Upton (http://www.uptonic.com/)
//
var Lightbox = Class.create();

Lightbox.prototype = {

	// initialize()
	// Constructor runs on completion of the DOM loading. Loops through anchor tags looking for
	// 'lightbox' references and applies onclick events to appropriate links. The 2nd section of
	// the function inserts html at the bottom of the page which is used to display the shadow
	// overlay and the image container.
	//
	initialize: function() {
		if (!document.getElementsByTagName){ return; }
		var anchors = document.getElementsByTagName('a');

		// loop through all anchor tags
		for (var i=0; i<anchors.length; i++){
			var anchor = anchors[i];

			var relAttribute = String(anchor.getAttribute('rel'));

			// use the string.match() method to catch 'lightbox' references in the rel attribute
			if (anchor.getAttribute('href') && (relAttribute.toLowerCase().match('lightbox'))){
				anchor.onclick = function () {myLightbox.start(this); return false;}
			}
		}

		// The rest of this code inserts html at the bottom of the page that looks similar to this:
		//
		//	<div id="overlay"></div>
		//	<div id="lightbox">
		//		<div id="outerImageContainer">
		//			<div id="imageContainer">
		//				<img id="lightboxImage">
		//				<div style="" id="hoverNav">
		//					<a href="#" id="prevLink"></a>
		//					<a href="#" id="nextLink"></a>
		//				</div>
		//				<div id="loading">
		//					<a href="#" id="loadingLink">
		//						<img src="images/loading.gif">
		//					</a>
		//				</div>
		//			</div>
		//		</div>
		//		<div id="imageDataContainer">
		//			<div id="imageData">
		//				<div id="imageDetails">
		//					<span id="caption"></span>
		//					<span id="numberDisplay"></span>
		//				</div>
		//				<div id="bottomNav">
		//					<a href="#" id="bottomNavClose">
		//						<img src="images/close.gif">
		//					</a>
		//				</div>
		//			</div>
		//		</div>
		//	</div>


		var objBody = document.getElementsByTagName("body").item(0);

		var objOverlay = document.createElement("div");
		objOverlay.setAttribute('id','overlay');
		objOverlay.style.display = 'none';
		objOverlay.onclick = function() { myLightbox.end(); return false; }
		objBody.appendChild(objOverlay);

		var objLightbox = document.createElement("div");
		objLightbox.setAttribute('id','lightbox');
		objLightbox.style.display = 'none';
		objBody.appendChild(objLightbox);

		var objOuterImageContainer = document.createElement("div");
		objOuterImageContainer.setAttribute('id','outerImageContainer');
		objLightbox.appendChild(objOuterImageContainer);

		var objImageContainer = document.createElement("div");
		objImageContainer.setAttribute('id','imageContainer');
		objOuterImageContainer.appendChild(objImageContainer);

		objLightboxImage = document.createElement("img");
		objLightboxImage.setAttribute('id','lightboxImage');
		objLightboxImage.setAttribute('width',''); //needed for proper resizing
		objLightboxImage.setAttribute('height',''); //needed for proper resizing
		objImageContainer.appendChild(objLightboxImage);

		var objHoverNav = document.createElement("div");
		objHoverNav.setAttribute('id','hoverNav');
		objImageContainer.appendChild(objHoverNav);

		var objPrevLink = document.createElement("a");
		objPrevLink.setAttribute('id','prevLink');
		objPrevLink.setAttribute('href','#');
		objPrevLink.setAttribute('onFocus', 'if (this.blur) this.blur()');
		objHoverNav.appendChild(objPrevLink);

		var objNextLink = document.createElement("a");
		objNextLink.setAttribute('id','nextLink');
		objNextLink.setAttribute('href','#');
		objNextLink.setAttribute('onFocus', 'if (this.blur) this.blur()');
		objHoverNav.appendChild(objNextLink);

		var objLoading = document.createElement("div");
		objLoading.setAttribute('id','loading');
		objImageContainer.appendChild(objLoading);

		var objLoadingLink = document.createElement("a");
		objLoadingLink.setAttribute('id','loadingLink');
		objLoadingLink.setAttribute('href','#');
		objLoadingLink.setAttribute('onFocus', 'if (this.blur) this.blur()');
		objLoadingLink.onclick = function() { myLightbox.end(); return false; }
		objLoading.appendChild(objLoadingLink);

		var objLoadingImage = document.createElement("img");
		objLoadingImage.setAttribute('src', fileLoadingImage);
		objLoadingLink.appendChild(objLoadingImage);

		objImageDataContainer = document.createElement("div");
		objImageDataContainer.setAttribute('id','imageDataContainer');
		objImageDataContainer.className = 'clearfix';
		objLightbox.appendChild(objImageDataContainer);

		var objImageData = document.createElement("div");
		objImageData.setAttribute('id','imageData');
		objImageDataContainer.appendChild(objImageData);

		var objImageDetails = document.createElement("div");
		objImageDetails.setAttribute('id','imageDetails');
		objImageData.appendChild(objImageDetails);

		var objCaption = document.createElement("span");
		objCaption.setAttribute('id','caption');
		objImageDetails.appendChild(objCaption);

		var objNumberDisplay = document.createElement("span");
		objNumberDisplay.setAttribute('id','numberDisplay');
		objImageDetails.appendChild(objNumberDisplay);


		//Bottom Navigation
		var objBottomNav = document.createElement("div");
		objBottomNav.setAttribute('id','bottomNav');
		objImageData.appendChild(objBottomNav);


		var objBottomNavCloseLink = document.createElement("a");
		objBottomNavCloseLink.setAttribute('id','bottomNavClose');
		objBottomNavCloseLink.setAttribute('href','#');
		objBottomNavCloseLink.setAttribute('onFocus', 'if (this.blur) this.blur()');
		objBottomNavCloseLink.onclick = function() { myLightbox.end(); return false; }
		objBottomNav.appendChild(objBottomNavCloseLink);

		var objBottomNavCloseImage = document.createElement("img");
		objBottomNavCloseImage.setAttribute('src', fileBottomNavCloseImage);
		objBottomNavCloseLink.appendChild(objBottomNavCloseImage);

  			// slide show link
	 		var objSlideShowLink = document.createElement("a");
			objSlideShowLink.setAttribute('id','slideshowLink');
			objSlideShowLink.setAttribute('href','#');
			objSlideShowLink.setAttribute('onFocus', 'if (this.blur) this.blur()');
			objSlideShowLink.onclick = function() { myLightbox.toggleSlideShow(); return false; }
			objBottomNav.appendChild(objSlideShowLink);

			objSlideShowImage = document.createElement("img");
			objSlideShowImage.setAttribute('src', SlideShowStartImage);
			objSlideShowLink.appendChild(objSlideShowImage);

			//music player
			var objFlashPlayer = document.createElement("div");
			objFlashPlayer.setAttribute('id','flashPlayer');
			objBottomNav.appendChild(objFlashPlayer);
	},

	//
	//	start()
	//	Display overlay and lightbox. If image is part of a set, add siblings to imageArray.
	//
	start: function(imageLink) {
		firstTime = 1;
		saveSlideshow = slideshow;
		saveForeverLoop = foreverLoop;
		saveLoopInterval = loopInterval;

		saveSlideShowWidth = slideShowWidth;
		saveSlideShowHeight = slideShowHeight;

		hideSelectBoxes();

		// stretch overlay to fill page and fade in
		var arrayPageSize = getPageSize();
		Element.setHeight('overlay', arrayPageSize[1]);
		new Effect.Appear('overlay', { duration: 0.2, from: 0.0, to: 0.8 });

		imageArray = [];
		imageNum = 0;

		if (!document.getElementsByTagName){ return; }
		var anchors = document.getElementsByTagName('a');

		// if image is NOT part of a set..
		if((imageLink.getAttribute('rel') == 'lightbox')){
			// add single image to imageArray
			imageArray.push(new Array(imageLink.getAttribute('href'), imageLink.getAttribute('title')));
		} else {
		// if image is part of a set..

			// loop through anchors, find other images in set, and add them to imageArray
			for (var i=0; i<anchors.length; i++){
				var anchor = anchors[i];
				if (anchor.getAttribute('href') && (anchor.getAttribute('rel') == imageLink.getAttribute('rel'))){
					imageArray.push(new Array(anchor.getAttribute('href'), anchor.getAttribute('title')));

					if (imageArray.length == 1) {
					  slideshowMusic = anchor.getAttribute('music');
					  if (slideshowMusic == null) {
						  Element.hide('flashPlayer');
					  } else
						{ Element.show('flashPlayer');	}

					  var startSlideshow = anchor.getAttribute('startslideshow');
					  if (startSlideshow != null) {
						if (startSlideshow == "false") slideshow = 0;
					  }

					  var forever = anchor.getAttribute('forever');
					  if (forever != null) {
						if (forever == "true") foreverLoop = 1; else foreverLoop = 0;
					  }
					  var slideDuration = anchor.getAttribute('slideDuration');
					  if (slideDuration != null) {
						loopInterval = slideDuration * 1000;
					  }
					  var width = anchor.getAttribute('slideshowwidth');
					  if (width != null) {
						slideShowWidth = width *1;
					  }
					  var height = anchor.getAttribute('slideshowheight');
					  if (height != null) {
						slideShowHeight = height *1;
					  }
					}

				}
			}

			imageArray.removeDuplicates();
			while(imageArray[imageNum][0] != imageLink.getAttribute('href')) { imageNum++;}
		}

		this.changeImageByTimer(imageNum);
	},

	showLightBox: function() {
		    // calculate top offset for the lightbox and display
	            var arrayPageSize = getPageSize();
		    var arrayPageScroll = getPageScroll();
		    var lightboxTop = arrayPageScroll[1] + (arrayPageSize[3] / 15);

		    Element.setTop('lightbox', lightboxTop);
		    Element.show('lightbox');
	},

	// changeImageByTimer()
	// changes image using timer, which prevents the loading gif from spinning
	// until the entire page is loaded
    	changeImageByTimer: function(imageNum) {
    			activeImage = imageNum;
    			this.imageTimer = setTimeout(function() {
    			this.showLightBox();
    			this.changeImage(activeImage);
    		}.bind(this), 10);
   	 },

	//
	//	changeImage()
	//	Hide most elements and preload image in preparation for resizing image container.
	//
	changeImage: function(imageNum) {

		activeImage = imageNum;	// update global var

		// hide elements during transition
		Element.show('loading');
		Element.hide('lightboxImage');
		Element.hide('hoverNav');
		Element.hide('prevLink');
		Element.hide('nextLink');


		if (firstTime == 1) {
	  	  Element.hide('imageDataContainer');
		  Element.hide('numberDisplay');
		  Element.hide('slideshowLink');
		}

		imgPreloader = new Image();

		// once image is preloaded, resize image container
		imgPreloader.onload=function(){
			Element.setSrc('lightboxImage', imageArray[activeImage][0]);

			objLightboxImage.setAttribute('width', imgPreloader.width);
			objLightboxImage.setAttribute('height', imgPreloader.height);

			if ((imageArray.length > 1) && (slideShowWidth != -1 || slideShowHeight != -1)) {
			   if (	(slideShowWidth >= imgPreloader.width) &&
			        (slideShowHeight >= imgPreloader.height)
			      ) {
			  myLightbox.resizeImageContainer(slideShowWidth, slideShowHeight);
			} else {
				  myLightbox.resizeImageAndContainer(imgPreloader.width, imgPreloader.height);
			}

			} else {
			  myLightbox.resizeImageAndContainer(imgPreloader.width, imgPreloader.height);
			}
		}
		imgPreloader.src = imageArray[activeImage][0];
	},

	resizeImageAndContainer: function(imgWidth, imgHeight) {
		if(resize == 1) {//resize mod by magarnicle
			useableWidth = 0.9; // 90% of the window
			useableHeight = 0.8; // 80% of the window
			var arrayPageSize = getPageSize();
			windowWidth = arrayPageSize[2];
			windowHeight = arrayPageSize[3];
			scaleX = 1; scaleY = 1;
			if ( imgWidth > windowWidth * useableWidth ) scaleX = (windowWidth * useableWidth) / imgWidth;
			if ( imgHeight > windowHeight * useableHeight ) scaleY = (windowHeight * useableHeight) / imgHeight;
			scale = Math.min( scaleX, scaleY );
			imgWidth *= scale;
			imgHeight *= scale;

			 objLightboxImage.setAttribute('width', imgWidth);
			 objLightboxImage.setAttribute('height', imgHeight);
		}
		this.resizeImageContainer(imgWidth, imgHeight);
	},

	//
	//	resizeImageContainer()
	//
	resizeImageContainer: function( imgWidth, imgHeight) {

		// get current height and width
		this.wCur = Element.getWidth('outerImageContainer');
		this.hCur = Element.getHeight('outerImageContainer');

		// scalars based on change from old to new
		this.xScale = ((imgWidth  + (borderSize * 2)) / this.wCur) * 100;
		this.yScale = ((imgHeight  + (borderSize * 2)) / this.hCur) * 100;

		// calculate size difference between new and old image, and resize if necessary
		wDiff = (this.wCur - borderSize * 2) - imgWidth;
		hDiff = (this.hCur - borderSize * 2) - imgHeight;

		if(!( hDiff == 0)){ new Effect.Scale('outerImageContainer', this.yScale, {scaleX: false, duration: resizeDuration, queue: 'front'}); }
		if(!( wDiff == 0)){ new Effect.Scale('outerImageContainer', this.xScale, {scaleY: false, delay: resizeDuration, duration: resizeDuration}); }

		// if new and old image are same size and no scaling transition is necessary,
		// do a quick pause to prevent image flicker.
		if((hDiff == 0) && (wDiff == 0)){
			if (navigator.appVersion.indexOf("MSIE")!=-1){ pause(250); } else { pause(100);}
		}

		Element.setHeight('prevLink', imgHeight);
		Element.setHeight('nextLink', imgHeight);
		Element.setWidth( 'imageDataContainer', imgWidth + (borderSize * 2));

		this.showImage();
	},

	//
	//	showImage()
	//	Display image and begin preloading neighbors.
	//
	showImage: function(){
		Element.hide('loading');
		new Effect.Appear('lightboxImage', { duration: 0.5, queue: 'end', afterFinish: function(){ myLightbox.updateDetails(); } });
		this.preloadNeighborImages();
	},

	//
	//	updateDetails()
	//	Display caption, image number, and bottom nav.
	//
	updateDetails: function() {

		Element.show('caption');
		if (imageArray[activeImage][1] != '') {
			Element.setInnerHTML( 'caption', imageArray[activeImage][1]);
		} else {
			Element.setInnerHTML( 'caption', "&nbsp;");
		}

		// if image is part of set display 'Image x of x'
		if(imageArray.length > 1){
			Element.show('numberDisplay');
			Element.setInnerHTML( 'numberDisplay', "" + eval(activeImage + 1) + " of " + imageArray.length);
		}

		if (firstTime == 1) {
                  //firstTime = 0;
		  new Effect.Parallel(
			[ new Effect.SlideDown( 'imageDataContainer', { sync: true, duration: resizeDuration + 0.25, from: 0.0, to: 1.0 }),
			  new Effect.Appear('imageDataContainer', { sync: true, duration: 1.0 }) ],
		 	{ duration: 0.65, afterFinish: function() { myLightbox.updateNav();} }
		  );
		} else {
		  //this code was commented out because it causes the music player to restart in Firefox
//		  new Effect.Parallel(
//			[ new Effect.Appear('imageDataContainer', { sync: true, duration: 1.0 }) ],
//		 	{ duration: 0.65, afterFinish: function() { myLightbox.updateNav();} }
//		  );
		  myLightbox.updateNav();
		}


			if (imageArray.length > 1) {
			   Element.show('flashPlayer');
			   Element.show('slideshowLink');
			}else {
			   Element.hide('flashPlayer');
			   Element.hide('slideshowLink');
			}

   		       if (slideshow == 1) {
				this.startSlideShow();
			   }

	},

	//
	//	updateNav()
	//	Display appropriate previous and next hover navigation.
	//
	updateNav: function() {

		Element.show('hoverNav');

		// if not first image in set, display prev image button
		if(activeImage != 0){
			Element.show('prevLink');
			document.getElementById('prevLink').onclick = function() {
				if (slideshow == 1) keyPressed = true;
				myLightbox.changeImage(activeImage - 1); return false;
			}
		}

		// if not last image in set, display next image button
		if(activeImage != (imageArray.length - 1)){
			Element.show('nextLink');
			document.getElementById('nextLink').onclick = function() {
				if (slideshow == 1) keyPressed = true;
				myLightbox.changeImage(activeImage + 1); return false;
			}
		}

		this.enableKeyboardNav();

		if (firstTime == 1) {
		  firstTime = 0;
		  if (imageArray.length > 1 && slideshow == 1) this.showMusicPlayer();
		  if (slideshow == 1) this.playMusic();
		}
	},

	//
	//	enableKeyboardNav()
	//
	enableKeyboardNav: function() {
		document.onkeydown = this.keyboardAction;
	},

	//
	//	disableKeyboardNav()
	//
	disableKeyboardNav: function() {
		document.onkeydown = '';
	},

	//
	//	keyboardAction()
	//
	keyboardAction: function(e) {
		if (e == null) { // ie
			keycode = event.keyCode;
		} else { // mozilla
			keycode = e.which;
		}

		key = String.fromCharCode(keycode).toLowerCase();

		if((key == 'x') || (key == 'o') || (key == 'c')){	// close lightbox
			myLightbox.end();
		} else if((keycode == 188) || (key == 'p')){	// display previous image
			if(activeImage != 0){
				if (slideshow == 1) keyPressed = true;
				myLightbox.disableKeyboardNav();
				myLightbox.changeImage(activeImage - 1);
			}
		} else if((keycode == 190) || (key == 'n')){	// display next image
			if(activeImage != (imageArray.length - 1)){
				if (slideshow == 1) keyPressed = true;
				myLightbox.disableKeyboardNav();
				myLightbox.changeImage(activeImage + 1);
			}
		}


	},

	//
	//	preloadNeighborImages()
	//	Preload previous and next images.
	//
	preloadNeighborImages: function(){

		if((imageArray.length - 1) > activeImage){
			preloadNextImage = new Image();
			preloadNextImage.src = imageArray[activeImage + 1][0];
		}
		if(activeImage > 0){
			preloadPrevImage = new Image();
			preloadPrevImage.src = imageArray[activeImage - 1][0];
		}

	},


	//
	//	toggleSlideShow()
	//	startSlideShow()
	//	stopSlideShow()
	//	Slideshow Functions
	//

	createMusicPlayer: function() {
	      var color = Element.getStyle('imageDataContainer', 'background-color').parseColor();
	      obj = new SWFObject(musicPlayer, "mymovie", "75", "30", "7", color);
	      obj.addVariable("soundPath", slideshowMusic);
	      obj.addVariable("playerSkin", "5"); //skin 1-5
	      return obj;
	},

	showMusicPlayer: function() {
	   if (slideshowMusic != null) {
	      Element.show('flashPlayer');
	      so = this.createMusicPlayer();

	      so.addVariable("autoPlay", "no");
	      so.write("flashPlayer");
	   } else {
		Element.hide('flashPlayer');
		}
	},

	playMusic: function() {
	   if (slideshowMusic != null) {
		  so = this.createMusicPlayer();

	      so.addVariable("autoPlay", "yes");
	      so.write("flashPlayer");
	   }
	},

	stopMusic: function() {
	   if ((slideshowMusic != null) && (so != null)) {
		   so = this.createMusicPlayer();

	     so.addVariable("autoPlay", "no");
	     so.write("flashPlayer");
       }
	},

	toggleSlideShow: function() {
		if(slideshow == 1) this.stopSlideShow();
		else {
		   this.playMusic();
		   if(activeImage == (imageArray.length-1)) {
			slideshow = 1;
			this.changeImage(0);
		   } else {
		   	this.startSlideShow();
		   }
		}
	},

	startSlideShow: function() {
		slideshow = 1;
		objSlideShowImage.setAttribute('src', SlideShowStopImage);
		this.slideShowTimer = setTimeout(function() {
			if (keyPressed) {
 				keyPressed = false;
				return;
			}
			if(activeImage < (imageArray.length-1)) this.changeImage(activeImage + 1);
			else {
				if(foreverLoop) this.changeImage(0);
				else {
					this.stopMusic();
					slideshow = 0;
					objSlideShowImage.setAttribute('src', SlideShowStartImage);
				}
			     }
		}.bind(this), loopInterval);
	},

	stopSlideShow: function() {
		slideshow = 0;
		objSlideShowImage.setAttribute('src', SlideShowStartImage);
		this.stopMusic();
		if(this.slideShowTimer) {
			clearTimeout(this.slideShowTimer);
			this.slideShowTimer = null;
			Element.setInnerHTML('flashPlayer', '');
		}
	},

	//
	//	end()
	//
	end: function() {
		this.stopSlideShow();
		this.disableKeyboardNav();
		Element.hide('lightbox');
		new Effect.Fade('overlay', { duration: 0.2});
		showSelectBoxes();

		slideshow = saveSlideshow;
		foreverLoop = saveForeverLoop;
		loopInterval = saveLoopInterval;

		slideShowWidth = saveSlideShowWidth;
		slideShowHeight = saveSlideShowHeight;
	}
}

// -----------------------------------------------------------------------------------

//
// getPageScroll()
// Returns array with x,y page scroll values.
// Core code from - quirksmode.org
//
function getPageScroll(){

	var yScroll;

	if (self.pageYOffset) {
		yScroll = self.pageYOffset;
	} else if (document.documentElement && document.documentElement.scrollTop){	 // Explorer 6 Strict
		yScroll = document.documentElement.scrollTop;
	} else if (document.body) {// all other Explorers
		yScroll = document.body.scrollTop;
	}

	arrayPageScroll = new Array('',yScroll)
	return arrayPageScroll;
}

// -----------------------------------------------------------------------------------

//
// getPageSize()
// Returns array with page width, height and window width, height
// Core code from - quirksmode.org
// Edit for Firefox by pHaez
//
function getPageSize(){

	var xScroll, yScroll;

	if (window.innerHeight && window.scrollMaxY) {
		xScroll = document.body.scrollWidth;
		yScroll = window.innerHeight + window.scrollMaxY;
	} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
		xScroll = document.body.scrollWidth;
		yScroll = document.body.scrollHeight;
	} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
		xScroll = document.body.offsetWidth;
		yScroll = document.body.offsetHeight;
	}

	var windowWidth, windowHeight;
	if (self.innerHeight) {	// all except Explorer
		windowWidth = self.innerWidth;
		windowHeight = self.innerHeight;
	} else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
		windowWidth = document.documentElement.clientWidth;
		windowHeight = document.documentElement.clientHeight;
	} else if (document.body) { // other Explorers
		windowWidth = document.body.clientWidth;
		windowHeight = document.body.clientHeight;
	}

	// for small pages with total height less then height of the viewport
	if(yScroll < windowHeight){
		pageHeight = windowHeight;
	} else {
		pageHeight = yScroll;
	}

	// for small pages with total width less then width of the viewport
	if(xScroll < windowWidth){
		pageWidth = windowWidth;
	} else {
		pageWidth = xScroll;
	}


	arrayPageSize = new Array(pageWidth,pageHeight,windowWidth,windowHeight)
	return arrayPageSize;
}

// -----------------------------------------------------------------------------------

//
// getKey(key)
// Gets keycode. If 'x' is pressed then it hides the lightbox.
//
function getKey(e){
	if (e == null) { // ie
		keycode = event.keyCode;
	} else { // mozilla
		keycode = e.which;
	}
	key = String.fromCharCode(keycode).toLowerCase();

	if(key == 'x'){
	}
}

// -----------------------------------------------------------------------------------

//
// listenKey()
//
function listenKey () {	document.onkeypress = getKey; }

// ---------------------------------------------------

function showSelectBoxes(){
	selects = document.getElementsByTagName("select");
	for (i = 0; i != selects.length; i++) {
		selects[i].style.visibility = "visible";
	}
}

// ---------------------------------------------------

function hideSelectBoxes(){
	selects = document.getElementsByTagName("select");
	for (i = 0; i != selects.length; i++) {
		selects[i].style.visibility = "hidden";
	}
}

// ---------------------------------------------------

//
// pause(numberMillis)
// Pauses code execution for specified time. Uses busy code, not good.
// Code from http://www.faqts.com/knowledge_base/view.phtml/aid/1602
//
function pause(numberMillis) {
	var now = new Date();
	var exitTime = now.getTime() + numberMillis;
	while (true) {
		now = new Date();
		if (now.getTime() > exitTime)
			return;
	}
}

// ---------------------------------------------------



function initLightbox() { myLightbox = new Lightbox(); }
//Event.observe(window, 'load', initLightbox, false);



//the code below suppose to help starting slideshow before a page is totaly loaded
function init() {
    // quit if this function has already been called
    if (arguments.callee.done) return;

    // flag this function so we don't do the same thing twice
    arguments.callee.done = true;

    // kill the timer
    if (_timer) {
        clearInterval(_timer);
        _timer = null;
    }

    // do onload stuff
    initLightbox();

};



/* for Mozilla */

if (document.addEventListener) {
    document.addEventListener("DOMContentLoaded", init, false);

}



/* for Internet Explorer */
/*@cc_on @*/
/*@if (@_win32)
    document.write("<script id=__ie_onload defer src=javascript:void(0)></script>");
    var script = document.getElementById("__ie_onload");
    script.onreadystatechange = function() {
        if (this.readyState == "complete") {
            init(); // call the onload handler
        }
    };
/*@end @*/



/* for Safari */
if (/WebKit/i.test(navigator.userAgent)) { // sniff
    var _timer = setInterval(function() {
        if (/loaded|complete/.test(document.readyState)) {
            init(); // call the onload handler
        }
    }, 10);
}



/* for other browsers */
//window.onload = init;
]]>
</script>

<script type="text/javascript">
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

/*					utils.js
 *
 *  (c) 2005 Siddique Hameed <siddii@gmail.com>
 *
 *
 *	Last Updated :	12/12/2006
 *  For details, see web site: http://www.TheRandomHomepage.com
 *
/*--------------------------------------------------------------------------*/

function getRandomNo(upperBound){
  return Math.floor(Math.random() * upperBound);
}

function getChildNodeValueByNodeName(node,nodeNameStr){
	var nodeList = node.childNodes;
	 for (var j = 0; j < nodeList.length ; j++) {
		var node = nodeList.item(j);
		if (node.nodeName == nodeNameStr && node.firstChild)
		{
			return node.firstChild.nodeValue;
		}
	 }
}

function getChildNodeByNodeName(node,nodeNameStr){
	var nodeList = node.childNodes;
	 for (var j = 0; j < nodeList.length ; j++) {
		var node = nodeList.item(j);
		if (node.nodeName == nodeNameStr)
		{
			return node;
		}
	 }
}

function extractBetween(str,startsWith,endsWith) {
	var startIdx =  str.indexOf(startsWith);
	if (startIdx != -1)
	{
		var endIdx = str.indexOf(endsWith,startIdx);
		if (endIdx != -1)
		{
			return str.substring(startIdx,endIdx+1);
		}
	}
	return "";
}


var rssFeedArr = new Array();

var prevIdx = -1;

var tags = "";
var transitionEffect = 0;
var imageClickBehaviour = 0;
var slideshowDelay = 0;

var controlElement = null;

var shouldBeRunning = true;

var RssFeed = Class.create();

	RssFeed.prototype = {

	   initialize: function(idx,title,link,desc,contentURL,thumbnailURL) {
			this.idx = idx;
			this.title = title;
			this.link = link;
			this.desc = desc;
			this.contentURL = contentURL;
			this.thumbnailURL = thumbnailURL;
	   },

	   getImage:function() {
		  var imgHTML =  "<a title='"+this.title+"' target='_new' id='lightboxAnc"+this.idx+"' style='display: none;' ";

		  if (imageClickBehaviour == 2) {
			imgHTML += " href='"+this.link+"' ";
		  }
		  else {
			imgHTML += " href='"+this.contentURL+"' ";
		  }

		  if (imageClickBehaviour == 0)
		  {
			imgHTML += " rel='lightbox["+tags+"]' ";
		  }

		  if (slideshowDelay > 0)
		  {
				imgHTML += " startslideshow='true' slideDuration='"+slideshowDelay+"' forever='true' ";
		  }
		  else {
			imgHTML += " startslideshow='false' ";
		  }
		  imgHTML += " >"+extractBetween(this.desc,"<img",">")+"</a>";
		  return imgHTML;
	   },

	   getTitle:function() {
		  return this.title;
	   }
	};

	function xmlResponseHandler(xhr) {
		var response = xhr.responseXML.documentElement
		var items = response.getElementsByTagName("item");
		var nodes = $A(items);
		var i = 0;

		nodes.each(function(itemNode){
				var title = getChildNodeValueByNodeName(itemNode,"title");
				var link = getChildNodeValueByNodeName(itemNode,"link");
				var desc = getChildNodeValueByNodeName(itemNode,"description");
				var content = getChildNodeByNodeName(itemNode,"media:content").getAttribute("url");
				var thumbnail = getChildNodeByNodeName(itemNode,"media:thumbnail").getAttribute("url");
				rssFeedArr[i] = new RssFeed(i,title,link,desc,content,thumbnail);
				i++;
	    });

		if (nodes.length > 0)
		{

			var lightboxHTML = "";
			rssFeedArr.each( function(rssFeed){
				lightboxHTML += rssFeed.getImage();
			});


			var divContent = $('divRandomFlickrContent');

			if (divContent)
			{
				alert(" lightboxHTML = "+lightboxHTML);
				Element.update(divContent,lightboxHTML);
				alert("After update ");
			}

			try
			{
				if (imageClickBehaviour == 0)
				{
					var overlayElement = $('overlay');

					if (overlayElement)
					{
						Element.remove(overlayElement);
					}

					var lightboxElement = $('lightbox');

					if (lightboxElement)
					{
						Element.remove(lightboxElement);
					}
					initLightbox();

						var overlayElement = document.getElementById("overlay");
						if (overlayElement)
						{
							var style = Element.getStyle(overlayElement,"border-bottom-color");
							alert(" overlayElementClassNames style = "+style);
						}

						var lightboxElement = document.getElementById("lightbox");
						if (lightboxElement)
						{
							var style = Element.getStyle(overlayElement,"border-bottom-color");
							alert(" lightboxElementClassNames = "+style);

						}
				}
				showRandomFlickrImage();
			}
			catch (e)
			{
				alert("Error "+e);
			}

			controlElement = $('divRandomFlickrControl');
			if (slideshowDelay > 0)
			{
				new PeriodicalExecuter(showRandomFlickrImage, slideshowDelay);
				Element.update(controlElement,"<img src='http://www.therandomhomepage.com/images/lightbox/stop.gif' onclick='stopSlideShow();' title='Stop Slideshow'/>");

				$(divRandomFlickrContent).onclick = stopSlideShow;
			}
			else {
				Element.update(controlElement,"&gt;&gt;");
				$("divRandomFlickrHeader").title = "Click on the arrows (>>) for next random picture";
				controlElement.title = "Next Random Picture";
				controlElement.onclick = function() {
					showRandomFlickrImage();
				}
			}
		}
		else {
			$('divRandomFlickrContent').innerHTML = "<center><I>Error retrieving pictures from Flickr! <br/>Please verify the tag names and try again later.</I></center>";
		}
	}

	function showRandomFlickrImage(){
		if (shouldBeRunning)
		{
			alert("showRandomFlickrImage ");
			if (prevIdx > -1)
			{
				var prevAnchorElement = $('lightboxAnc'+prevIdx);
				Element.hide(prevAnchorElement);
			}

			var randIdx = getRandomNo(rssFeedArr.length);

			alert("randIdx "+randIdx);

			var ancElem = $('lightboxAnc'+randIdx);
			if (ancElem)
			{
				$("divRandomFlickrHeader").innerHTML = rssFeedArr[randIdx].getTitle();
				Element.show(ancElem);
				applyEffect($("divRandomFlickrContent"),transitionEffect);
				prevIdx = randIdx;
			}
		}
	}


	function stopSlideShow(){
		if (shouldBeRunning)
		{
			Element.update(controlElement,"<img src='http://www.therandomhomepage.com/images/lightbox/start.gif' onclick='startSlideShow();' title='Start Slideshow'/>");
			shouldBeRunning = false;
		}
	}

	function startSlideShow(){
		if (!shouldBeRunning)
		{
			Element.update(controlElement,"<img src='http://www.therandomhomepage.com/images/lightbox/stop.gif' onclick='stopSlideShow();' title='Stop Slideshow'/>");
			shouldBeRunning = true;
		}
	}

	function randomFlickrLoad(){
		tags = getValue("tags") != "undefined" ? getValue("tags") : "art,colorful,travel";
		transitionEffect = getValue("transition_effect") != "undefined" ? getValue("transition_effect") : 0;
		imageClickBehaviour = getValue("image_click_behaviour") != "undefined" ? getValue("image_click_behaviour") : 0;
		slideshowDelay = getValue("slideshow_delay") != "undefined" ? getValue("slideshow_delay") : 0;
		var flickrFeedURL = "http://www.flickr.com/services/feeds/photos_public.gne?tags="+tags+"&format=rss_200";
		if (!NV_XML_REQUEST_URL )
		{
			NV_XML_REQUEST_URL = "http://www.netvibes.com/xmlProxy.php";
		}
		var request = new Ajax.Request(NV_XML_REQUEST_URL + '?url=' + escape(flickrFeedURL), { method: 'get', onSuccess: xmlResponseHandler});
	}

	function applyLightboxStyleSheet() {
		var style = document.createElement('link');
		style.setAttribute('rel', 'stylesheet');
		style.setAttribute('type', 'text/css');
		style.setAttribute('media', 'screen');
		style.setAttribute('href', 'http://www.therandomhomepage.com/css/lightbox.css' );
		var head = document.getElementsByTagName('head').item(0);
		head.appendChild( style );
	}

NV_ONLOAD = function()
{
	applyLightboxStyleSheet();
    randomFlickrLoad();
	//_uacct = "UA-941159-1";
	//urchinTracker();
}
</script>
</head>

<body>
<table width="100%"><tr><td><div id="divRandomFlickrHeader"></div></td><td align="right" valign="top"><div id="divRandomFlickrControl"></div></td></tr>
<tr colspan="2"><td><div id="divRandomFlickrContent"><center><I>Loading...</I></center></div></td></tr>
</table>
<form class="configuration" method="post" action="">
    <table border="0">
        <tr>
            <td><label>Title:</label></td>
            <td><input name="title" type="text" value="Random Flickring" size="20"/></td>
        </tr>
        <tr>
            <td><label>Tags(comma separated):</label></td>
            <td><input name="tags" type="text" value="art,colorful,travel" size="30"/></td>
        </tr>
        <tr>
            <td><label>Transition effect:</label></td>
            <td>
                <select name="transition_effect" style="vertical-align: top; padding: 0; margin: 0 0.4em;">
                    <option value="-1">None</option>
                    <option value="0" selected="selected">Random</option>
                    <option value="1">BlindDown</option>
                    <option value="2">Highlight</option>
                    <option value="3">Shake</option>
                    <option value="4">Pulsate</option>
                    <option value="5">Grow</option>
                    <option value="6">Slidedown</option>
                </select>
            </td>
        </tr>
        <tr>
          <td colspan="2">
          <label>Slideshow delay in seconds:</label> <select name="slideshow_delay"><option selected="selected" value="0">No slideshow</option><option value="5">5</option><option value="10">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option><option value="30">30</option><option value="35">35</option><option value="40">40</option><option value="45">45</option><option value="50">50</option><option value="55">55</option><option value="60">60</option>
          </select>
          </td>
        </tr>
        <tr>
          <td colspan="2">
          <label>On Image Click:</label> <select name="image_click_behaviour"><option selected="selected" value="0">Lightbox Effect</option><option value="1">Open Original Image</option><option value="2">Open Flickr Link</option></select>
          </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="OK"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>