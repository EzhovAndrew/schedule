'use strict';

window.addEventListener('DOMContentLoaded', () => {
    const getButton = document.querySelector('#Get-button');

    getButton.addEventListener('click', () => {
        const objectList = ["Студенты", "Преподаватели", "Аудитории", "Расписание", "Курсы"];
        const objectIds = [
            'Get-btn-students',
            'Get-btn-profs',
            'Get-btn-classrooms',
            'Get-btn-lessons',
            'Get-btn-courses',
        ];

        const modalTitle = document.querySelector('.modal-title');
        modalTitle.textContent = 'Получение объектов';
        const hint = document.querySelector('#modal-hint');
        hint.textContent = 'Нажмите на кнопку желаемого объекта';

        const bodyButtonsContainer = document.querySelector('.modal-body-buttons');
        bodyButtonsContainer.classList.add('mid-height');
        bodyButtonsContainer.classList.remove('fluid-height');
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

        const getBtnStudents = document.getElementById('Get-btn-students');
        getBtnStudents.addEventListener('click', () => {
            initializeFormContainer(
                bodyButtonsContainer,
                modalTitle,
                'Получение студентов',
                hint
            );
            
            let form = getStudentForm(false);
            form.setAttribute('id', 'FormToGetStudents');
            bodyButtonsContainer.textContent = '';
            bodyButtonsContainer.append(form);

        });

        const getBtnProfs = document.getElementById('Get-btn-profs');
        getBtnProfs.addEventListener('click', () => {
            initializeFormContainer(
                bodyButtonsContainer,
                modalTitle,
                'Получение преподавателей',
                hint
            );

            let form = getProfessorsForm(false);
            form.setAttribute('id', 'FormToGetProfs');
            bodyButtonsContainer.textContent = '';
            bodyButtonsContainer.append(form);
        });

        const getBtnClassrooms = document.getElementById('Get-btn-classrooms');
        getBtnClassrooms.addEventListener('click', () => {
            initializeFormContainer(
                bodyButtonsContainer,
                modalTitle,
                'Получение списка аудиторий',
                hint
            );

            let form = getClassroomForm();
            form.setAttribute('id', 'FormToGetClassrooms');
            bodyButtonsContainer.textContent = '';
            bodyButtonsContainer.append(form);
        });

        const getBtnLessons = document.getElementById('Get-btn-lessons');
        getBtnLessons.addEventListener('click', () => {
            modalTitle.textContent = 'Получение расписания';
            hint.textContent = 'Нажмите на кнопку желаемого объекта';
            const lessonsForList = ['Студент', 'Преподаватель', 'Аудитория'];
            const lessonsForListIds = ['Get-btn-lessons-students', 'Get-btn-lessons-profs', 'Get-btn-lessons-classrooms'];

            bodyButtonsContainer.classList.add('mid-height');
            bodyButtonsContainer.classList.remove('fluid-height');
            bodyButtonsContainer.textContent = '';
            for (let key in lessonsForList) {
                let button = document.createElement('button');
                button.classList.add('btn');
                button.classList.add('btn-primary');
                button.classList.add('btn-lg');
                button.textContent = lessonsForList[key];
                button.setAttribute('id', lessonsForListIds[key]);
                bodyButtonsContainer.append(button);
            }

            const getBtnLessonsStudent = document.getElementById('Get-btn-lessons-students');
            getBtnLessonsStudent.addEventListener('click', () => {
                initializeFormContainer(
                    bodyButtonsContainer,
                    modalTitle,
                    'Получение расписания студента',
                    hint
                );

                const studentLessonsForm = getObjectLessonsForm('student_id', 'студента', 'FormToGetStudentSchedule');

                bodyButtonsContainer.textContent = '';
                bodyButtonsContainer.append(studentLessonsForm);
            });

            const getBtnLessonsProfs = document.getElementById('Get-btn-lessons-profs');
            getBtnLessonsProfs.addEventListener('click', () => {
                initializeFormContainer(
                    bodyButtonsContainer,
                    modalTitle,
                    'Получение расписания преподавателя',
                    hint
                );
                
                const profForm = getObjectLessonsForm('professor_id', 'преподавателя', 'FormToGetProfSchedule')

                bodyButtonsContainer.textContent = '';
                bodyButtonsContainer.append(profForm);
            });

            const getBtnLessonsClassroom = document.getElementById('Get-btn-lessons-classrooms');
            getBtnLessonsClassroom.addEventListener('click', () => {
                initializeFormContainer(
                    bodyButtonsContainer,
                    modalTitle,
                    'Получение расписания аудитории',
                    hint
                );

                const classroomForm = getObjectLessonsForm('classroom_id', 'аудитории', 'FormToGetClassroomSchedule')
                const label = classroomForm.querySelector('label[for="idLessonsGet"]');
                const help = classroomForm.querySelector('#idHelp');
                help.textContent = 'Введите, пожалуйста, номер аудитории. Поле обязательно к заполнению';
                label.textContent = 'Номер аудитории';
                bodyButtonsContainer.textContent = '';
                bodyButtonsContainer.append(classroomForm);
            });
        });
    });
});