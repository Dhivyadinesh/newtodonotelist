(function() {
  'use strict';
  var app = {
    noteEditor: document.getElementById('note-editor'),
    noteEditorTitle: document.getElementById('note-editor-title'),
    title: document.getElementById('title'),
    item: document.getElementById('item'),
    color: document.getElementById('color'),
    addButton: document.getElementById('add-btn'),
    errorDisplay: document.getElementById('error'),
    editButton: document.querySelector('.edit'),
    notesSection: document.getElementById('notes-section'),
    notes: document.getElementById('notes'),
    editMode: false,

    init: function() {
      app.addButton.addEventListener('click', app.createNote);
    },

    createNote: function() {
      if(!app.title.value || !app.item.value) {
        app.errorDisplay.innerHTML = '<span>*Values Must be required</span>';
        return;
        } 
        else {
        var note = new Object();
        note.title = app.title.value;
        note.item = app.item.value;
        note.color = app.color.value;
        app.addNote(note);
      }
    },

    addNote: function(note) {
      var li = document.createElement('li'),
      editBtn = document.createElement('span'),
      title = document.createElement('span'),
      item = document.createElement('span'),
      footer = document.createElement('footer');

      title.className = 'note-title';
      title.innerHTML = note.title;

      item.className = 'note-item';
      item.innerHTML = note.item;

      editBtn.className = 'edit';
      editBtn.innerHTML = '<i class="fa fa-pencil-square-o"></i> Edit';
      editBtn.addEventListener('click', app.editNote);

      footer.appendChild(editBtn);
      
      li.className = note.color;
      li.appendChild(title);
      li.appendChild(item);
      li.appendChild(footer);

      app.notes.prepend(li);
      app.title.value = '';
      app.item.value = '';

      if(!app.editMode) {
        app.addButton.innerText = 'Create Note';
      } else {
        setTimeout(function() {
          app.addButton.innerText = 'Create Note';
        }, 1000);
      }
    },

    editNote: function() {
      var li,
      title,
      item,
      color,
      note = new Object();

      li = this.parentNode.parentNode;

      for(var i = 0; i < li.childNodes.length; i++) {
        if(li.childNodes[i].className === 'note-title') {
          title = li.childNodes[i].innerText;
        }
      }

      for(var i = 0; i < li.childNodes.length; i++) {
        if(li.childNodes[i].className === 'note-item') {
          item = li.childNodes[i].innerText;
        }
      }

      color = li.getAttribute('class');

      note.title = title;
      note.item = item;
      note.color = color;
      
      app.openNote(note);

      setTimeout(function() {
        li.remove();
      }, 1000);
    },

    openNote: function(note) {
      if(!app.editMode) {
        app.noteEditor.classList.add('hide');
        app.notesSection.classList.add('hide');
      
        setTimeout(function() {
          app.noteEditorTitle.innerText = 'Edit Note';
          
          app.addButton.innerText = 'Done';
          app.addButton.removeEventListener('click', app.createNote);
          app.addButton.addEventListener('click', app.saveNote);

          app.title.value = note.title;
          app.item.value = note.item;
          app.color.value = note.color;

          app.noteEditor.classList.remove('hide');
          app.editMode = true;
        }, 1000);
      } else {
        return;
      }  
    },

    saveNote: function() {
      app.createNote();

      app.noteEditor.classList.add('hide');
      app.notesSection.classList.add('hide');
    
      setTimeout(function() {
        app.noteEditorTitle.innerText = 'Create Note';

        app.addButton.removeEventListener('click', app.saveNote);
        app.addButton.addEventListener('click', app.createNote);

        app.title.value = '';
        app.item.value = '';

        app.notesSection.classList.remove('hide');
        app.noteEditor.classList.remove('hide');
        app.editMode = false;
      }, 2000);
    },    
  };

  deleteNote: function(){
}
  app.init();
})();