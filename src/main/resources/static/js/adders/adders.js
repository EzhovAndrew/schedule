'use strict';

window.addEventListener('DOMContentLoaded', () => {
    const addButton = document.querySelector('#Add-button');

    addButton.addEventListener('click', () => {
        const objectList = ["Студент", "Преподаватель", "Аудитория", "Занятие", "Курс"];
        const objectIds = [
            'Add-btn-students',
            'Add-btn-profs',
            'Add-btn-classrooms',
            'Add-btn-lessons',
            'Add-btn-courses',
        ];

        const modalTitle = document.querySelector('.modal-title');
        modalTitle.textContent = 'Добавление объекта';
        const hint = document.querySelector('#modal-hint');
        hint.textContent = 'Нажмите на кнопку желаемого объекта';

        const bodyButtonsContainer = document.querySelector('.modal-body-buttons');
        bodyButtonsContainer.classList.remove('fluid-height');
        bodyButtonsContainer.classList.add('mid-height');
        bodyButtonsContainer.textContent = '';
        for (let key in objectList) {
            let button = document.createElement('button');
            button.classList.add('btn');
            button.classList.add('btn-primary');
            button.classList.add('btn-lg');
            button.textContent = objectList[key];
            button.setAttribute('id', objectIds[key]);
            bodyButtonsContainer.append(button);
        }

        const addBtnStudents = document.getElementById('Add-btn-students');
        addBtnStudents.addEventListener('click', () => {
            initializeFormContainer(
                bodyButtonsContainer,
                modalTitle,
                'Добавление студента',
                hint
            );

            const form =  getStudentAddForm(true);
            form.setAttribute('id', 'FormToAddStudent');
            bodyButtonsContainer.textContent = '';
            bodyButtonsContainer.append(form);

        });

        const addBtnProfs = document.getElementById('Add-btn-profs');
        addBtnProfs.addEventListener('click', () => {
            initializeFormContainer(
                bodyButtonsContainer,
                modalTitle,
                'Добавление преподавателя',
                hint
            );

            const form = getProfessorsForm(true);
            const submitButton = form.querySelector('button');
            submitButton.setAttribute('id', 'formProfAddButton');
            submitButton.textContent = 'Добавить';
            form.setAttribute('id', 'FormToAddProf');
            bodyButtonsContainer.textContent = '';
            bodyButtonsContainer.append(form);
        });

        const addBtnClassrooms = document.getElementById('Add-btn-classrooms');
        addBtnClassrooms.addEventListener('click', () => {
            initializeFormContainer(
                bodyButtonsContainer,
                modalTitle,
                'Добавление аудитории',
                hint
            );
            const form = getClassroomAddForm();
            form.setAttribute('id', 'FormToAddClassroom');
            bodyButtonsContainer.textContent = '';
            bodyButtonsContainer.append(form);
        });

        const addBtnLessons = document.getElementById('Add-btn-lessons');
        addBtnLessons.addEventListener('click', () => {
            initializeFormContainer(
                bodyButtonsContainer,
                modalTitle,
                'Добавление занятия',
                hint
            );

            const form = getLessonAddForm();
            form.setAttribute('id', 'FormToAddLesson');
            bodyButtonsContainer.textContent = '';
            bodyButtonsContainer.append(form);
        });

        const addBtnCourses = document.getElementById('Add-btn-courses');
        addBtnCourses.addEventListener('click', () => {
            initializeFormContainer(
                bodyButtonsContainer,
                modalTitle,
                'Добавление курса',
                hint
            );
            
            const form = getCourseAddForm();
            form.setAttribute('id', 'FormToAddCourse');
            bodyButtonsContainer.textContent = '';
            bodyButtonsContainer.append(form);
        });

    });
});