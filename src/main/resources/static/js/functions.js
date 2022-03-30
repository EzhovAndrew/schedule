'use strict';

function getStudentForm (add_form) {
    let form = document.createElement('form');

    let nameField = document.createElement('div');
    nameField.classList.add('mb-3');
    let inputNameField = document.createElement('input');
    inputNameField.setAttribute('id', 'StudentNameFieldInput');
    inputNameField.setAttribute('type', 'text');
    inputNameField.setAttribute('aria-describedby', 'nameHelp');
    inputNameField.setAttribute('name', 'name');
    inputNameField.classList.add('form-control');
    if (add_form) {
        inputNameField.required = true;
    }
    let labelNameField = document.createElement('label');
    labelNameField.classList.add('form-label');
    labelNameField.setAttribute('for', 'StudentNameFieldInput');
    labelNameField.textContent = 'Имя студента';
    let hintNameField = document.createElement('div');
    hintNameField.classList.add('form-text')
    hintNameField.setAttribute('id', 'nameHelp');
    hintNameField.textContent = 'Оставьте поле пустым, если не хотите указывать конкретного студента';
    nameField.append(labelNameField);
    nameField.append(inputNameField);
    nameField.append(hintNameField);
    form.append(nameField);

    let surnameField = document.createElement('div');
    surnameField.classList.add('mb-3');
    let inputSurnameField = document.createElement('input');
    inputSurnameField.setAttribute('id', 'StudentSurnameFieldInput');
    inputSurnameField.setAttribute('type', 'text');
    inputSurnameField.setAttribute('aria-describedby', 'surnameHelp');
    inputSurnameField.setAttribute('name', 'surname');
    inputSurnameField.classList.add('form-control');
    if (add_form) {
        inputSurnameField.required = true;
    }
    let labelSurnameField = document.createElement('label');
    labelSurnameField.classList.add('form-label');
    labelSurnameField.setAttribute('for', 'StudentSurnameFieldInput');
    labelSurnameField.textContent = 'Фамилия студента';
    let hintSurnameField = document.createElement('div');
    hintSurnameField.classList.add('form-text')
    hintSurnameField.setAttribute('id', 'surnameHelp');
    hintSurnameField.textContent = 'Оставьте поле пустым, если не хотите указывать конкретного студента';
    surnameField.append(labelSurnameField);
    surnameField.append(inputSurnameField);
    surnameField.append(hintSurnameField);
    form.append(surnameField);

    let patronymicField = document.createElement('div');
    patronymicField.classList.add('mb-3');
    let inputPatronymicField = document.createElement('input');
    inputPatronymicField.setAttribute('id', 'StudentPatronymicFieldInput');
    inputPatronymicField.setAttribute('type', 'text');
    inputPatronymicField.setAttribute('aria-describedby', 'patronymicHelp');
    inputPatronymicField.setAttribute('name', 'patronymic');
    inputPatronymicField.classList.add('form-control');
    if (add_form) {
        inputPatronymicField.required = true;
    }
    let labelPatronymicField = document.createElement('label');
    labelPatronymicField.classList.add('form-label');
    labelPatronymicField.setAttribute('for', 'StudentPatronymicFieldInput');
    labelPatronymicField.textContent = 'Отчество студента';
    let hintPatronymicField = document.createElement('div');
    hintPatronymicField.classList.add('form-text')
    hintPatronymicField.setAttribute('id', 'patronymicHelp');
    hintPatronymicField.textContent = 'Оставьте поле пустым, если не хотите указывать конкретного студента';
    patronymicField.append(labelPatronymicField);
    patronymicField.append(inputPatronymicField);
    patronymicField.append(hintPatronymicField);
    form.append(patronymicField);

    let groupField = document.createElement('div');
    groupField.classList.add('mb-3');
    let inputGroupField = document.createElement('input');
    inputGroupField.setAttribute('id', 'StudentGroupFieldInput')
    inputGroupField.setAttribute('type', 'number');
    inputGroupField.setAttribute('min', '100');
    inputGroupField.setAttribute('max', '699');
    inputGroupField.setAttribute('aria-describedby', 'groupHelp');
    inputGroupField.setAttribute('name', 'group');
    inputGroupField.classList.add('form-control');
    let labelGroupField = document.createElement('label');
    labelGroupField.textContent = 'Группа студента';
    labelGroupField.classList.add('form-label');
    labelGroupField.setAttribute('for', 'StudentGroupFieldInput');
    let hintGroupField = document.createElement('div');
    hintGroupField.classList.add('form-text');
    hintGroupField.setAttribute('id', 'groupHelp');
    hintGroupField.textContent = 'Оставьте поле пустым, если не хотите указывать конкретного студента';
    groupField.append(labelGroupField);
    groupField.append(inputGroupField);
    groupField.append(hintGroupField);
    form.append(groupField);

    let streamField = document.createElement('div');
    streamField.classList.add('mb-3');
    let inputStreamField = document.createElement('input');
    inputStreamField.setAttribute('id', 'StudentStreamFieldInput')
    inputStreamField.setAttribute('type', 'number');
    inputStreamField.setAttribute('min', '1');
    inputStreamField.setAttribute('max', '6');
    inputStreamField.setAttribute('aria-describedby', 'streamHelp');
    inputStreamField.setAttribute('name', 'stream');
    inputStreamField.classList.add('form-control');
    let labelStreamField = document.createElement('label');
    labelStreamField.textContent = 'Поток студента';
    labelStreamField.classList.add('form-label');
    labelStreamField.setAttribute('for', 'StudentStreamFieldInput');
    let hintStreamField = document.createElement('div');
    hintStreamField.classList.add('form-text');
    hintStreamField.setAttribute('id', 'streamHelp');
    hintStreamField.textContent = 'Оставьте поле пустым, если не хотите указывать конкретного студента';
    streamField.append(labelStreamField);
    streamField.append(inputStreamField);
    streamField.append(hintStreamField);
    form.append(streamField);

    let formGetButton = document.createElement('button');
    formGetButton.classList.add('btn');
    formGetButton.classList.add('btn-primary');
    formGetButton.setAttribute('id', 'formStudentsGetButton');
    formGetButton.setAttribute('type', 'submit');
    formGetButton.textContent = 'Получить';
    form.append(formGetButton);

    return form;
}

function getProfessorsForm(add_form) {
    let form = document.createElement('form');

    let nameField = document.createElement('div');
    nameField.classList.add('mb-3');
    let inputNameField = document.createElement('input');
    inputNameField.setAttribute('id', 'ProfNameFieldInput');
    inputNameField.setAttribute('type', 'text');
    inputNameField.setAttribute('aria-describedby', 'nameHelp');
    inputNameField.setAttribute('name', 'name');
    inputNameField.classList.add('form-control');
    if (add_form) {
        inputNameField.setAttribute('required', '');
    }
    let labelNameField = document.createElement('label');
    labelNameField.classList.add('form-label');
    labelNameField.setAttribute('for', 'ProfNameFieldInput');
    labelNameField.textContent = 'Имя преподавателя';
    let hintNameField = document.createElement('div');
    hintNameField.classList.add('form-text')
    hintNameField.setAttribute('id', 'nameHelp');
    hintNameField.textContent = 'Поле является обязательным к заполнению. Внимательно проверяйте введенные данные.';
    nameField.append(labelNameField);
    nameField.append(inputNameField);
    nameField.append(hintNameField);
    form.append(nameField);

    let surnameField = document.createElement('div');
    surnameField.classList.add('mb-3');
    let inputSurnameField = document.createElement('input');
    inputSurnameField.setAttribute('id', 'ProfSurnameFieldInput');
    inputSurnameField.setAttribute('type', 'text');
    inputSurnameField.setAttribute('aria-describedby', 'surnameHelp');
    inputSurnameField.setAttribute('name', 'surname');
    inputSurnameField.classList.add('form-control');
    if (add_form) {
        inputSurnameField.setAttribute('required', '');
    }
    let labelSurnameField = document.createElement('label');
    labelSurnameField.classList.add('form-label');
    labelSurnameField.setAttribute('for', 'ProfSurnameFieldInput');
    labelSurnameField.textContent = 'Фамилия преподавателя';
    let hintSurnameField = document.createElement('div');
    hintSurnameField.classList.add('form-text')
    hintSurnameField.setAttribute('id', 'surnameHelp');
    hintSurnameField.textContent = 'Поле является обязательным к заполнению. Внимательно проверяйте введенные данные.';
    surnameField.append(labelSurnameField);
    surnameField.append(inputSurnameField);
    surnameField.append(hintSurnameField);
    form.append(surnameField);

    let patronymicField = document.createElement('div');
    patronymicField.classList.add('mb-3');
    let inputPatronymicField = document.createElement('input');
    inputPatronymicField.setAttribute('id', 'ProfPatronymicFieldInput');
    inputPatronymicField.setAttribute('type', 'text');
    inputPatronymicField.setAttribute('aria-describedby', 'patronymicHelp');
    inputPatronymicField.setAttribute('name', 'patronymic');
    inputPatronymicField.classList.add('form-control');
    if (add_form) {
        inputPatronymicField.setAttribute('required', '');
    }
    let labelPatronymicField = document.createElement('label');
    labelPatronymicField.classList.add('form-label');
    labelPatronymicField.setAttribute('for', 'ProfPatronymicFieldInput');
    labelPatronymicField.textContent = 'Отчество преподавателя';
    let hintPatronymicField = document.createElement('div');
    hintPatronymicField.classList.add('form-text')
    hintPatronymicField.setAttribute('id', 'patronymicHelp');
    hintPatronymicField.textContent = 'Поле является обязательным к заполнению. Внимательно проверяйте введенные данные.';
    patronymicField.append(labelPatronymicField);
    patronymicField.append(inputPatronymicField);
    patronymicField.append(hintPatronymicField);
    form.append(patronymicField);

    let formGetButton = document.createElement('button');
    formGetButton.classList.add('btn');
    formGetButton.classList.add('btn-primary');
    formGetButton.setAttribute('id', 'formProfsGetButton');
    formGetButton.setAttribute('type', 'submit');
    formGetButton.textContent = 'Получить';
    form.append(formGetButton);

    return form;
}

function getClassroomForm() {
    let form = document.createElement('form');

    let startField = document.createElement('div');
    startField.classList.add('mb-3');
    let inputStartField = document.createElement('input');
    inputStartField.setAttribute('id', 'ClassroomsStartFieldInput');
    inputStartField.setAttribute('aria-describedby', 'startHelp');
    inputStartField.setAttribute('type', 'datetime-local');
    inputStartField.setAttribute('name', 'startTime');
    inputStartField.setAttribute('required', null);
    inputStartField.classList.add('form-control');
    let labelStartField = document.createElement('label');
    labelStartField.classList.add('form-label');
    labelStartField.setAttribute('for', 'ClassroomsStartFieldInput');
    labelStartField.textContent = 'Начало';
    let hintStartField = document.createElement('div');
    hintStartField.classList.add('form-text');
    hintStartField.setAttribute('id', 'startHelp');
    hintStartField.textContent = 'Введите начало временного промежутка для поиска подходящих аудиторий'
    startField.append(labelStartField);
    startField.append(inputStartField);
    startField.append(hintStartField);
    form.append(startField);

    let endField = document.createElement('div');
    endField.classList.add('mb-3');
    let inputEndField = document.createElement('input');
    inputEndField.setAttribute('id', 'ClassroomsEndFieldInput');
    inputEndField.classList.add('form-control');
    inputEndField.setAttribute('type', 'datetime-local');
    inputEndField.setAttribute('aria-describedby', 'endHelp');
    inputEndField.setAttribute('name', 'endTime');
    inputEndField.setAttribute('required', null);
    let labelEndField = document.createElement('label');
    labelEndField.classList.add('form-label');
    labelEndField.setAttribute('for', 'ClassroomsEndFieldInput');
    labelEndField.textContent = 'Конец';
    let hintEndField = document.createElement('div');
    hintEndField.classList.add('form-text');
    hintEndField.setAttribute('id', 'endHelp');
    hintEndField.textContent = 'Введите конец временного промежутка для поиска подходящих аудиторий'
    endField.append(labelEndField);
    endField.append(inputEndField);
    endField.append(hintEndField);
    form.append(endField);

    let formGetButton = document.createElement('button');
    formGetButton.classList.add('btn');
    formGetButton.classList.add('btn-primary');
    formGetButton.setAttribute('id', 'formClassroomsGetButton');
    formGetButton.setAttribute('type', 'submit');
    formGetButton.textContent = 'Получить';
    form.append(formGetButton);

    return form;
}

function initializeFormContainer(container, title, titleText, hint) {
    container.classList.remove('mid-height');
    container.classList.add('fluid-height');
    title.textContent = titleText;
    hint.textContent = 'Заполните форму';
}

function getAddButton(id) {
    let formGetButton = document.createElement('button');
    formGetButton.classList.add('btn');
    formGetButton.classList.add('btn-primary');
    formGetButton.setAttribute('id', id);
    formGetButton.setAttribute('type', 'submit');
    formGetButton.textContent = 'Добавить';

    return formGetButton;
}


function getStudentAddForm(add_form) {
    const form = getStudentForm(add_form);
    const inputs = form.querySelectorAll('input');
    inputs.forEach((input) => {input.setAttribute('required', null)});
    const lastStudentField = form.querySelector('#StudentStreamFieldInput').closest('div');
    
    let yearStudentField = document.createElement('div');
    yearStudentField.classList.add('mb-3');
    let inputYearField = document.createElement('input');
    inputYearField.setAttribute('id', 'StudentYearFieldInput')
    inputYearField.setAttribute('type', 'number');
    inputYearField.setAttribute('min', '1');
    inputYearField.setAttribute('max', '6');
    inputYearField.setAttribute('aria-describedby', 'studentYearHelp');
    inputYearField.setAttribute('name', 'year');
    inputYearField.setAttribute('required', null);
    inputYearField.classList.add('form-control');
    inputYearField.required = true;
    let labelYearField = document.createElement('label');
    labelYearField.textContent = 'Год обучения';
    labelYearField.classList.add('form-label');
    labelYearField.setAttribute('for', 'StudentYearFieldInput');
    let hintYearField = document.createElement('div');
    hintYearField.classList.add('form-text');
    hintYearField.setAttribute('id', 'studentYearHelp');
    hintYearField.textContent = 'В данном поле подразумевается курс студента, а не календарный год. Поле обязательно к заполнению.';
    yearStudentField.append(labelYearField);
    yearStudentField.append(inputYearField);
    yearStudentField.append(hintYearField);
    lastStudentField.after(yearStudentField);

    const submitButton = form.querySelector('button');
    submitButton.setAttribute('id', 'formStudentAddButton');
    submitButton.textContent = 'Добавить';
    form.querySelector('#nameHelp').textContent = 'Поле обязательно к заполнению.';
    form.querySelector('#surnameHelp').textContent = 'Поле обязательно к заполнению.';
    form.querySelector('#patronymicHelp').textContent = 'Поле обязательно к заполнению.';

    return form;
}

function getClassroomAddForm() {
    const form = document.createElement('form');

    let numField = document.createElement('div');
    numField.classList.add('mb-3');
    let inputNumField = document.createElement('input');
    inputNumField.setAttribute('id', 'ClassroomNumFieldInput')
    inputNumField.setAttribute('type', 'number');
    inputNumField.setAttribute('min', '100');
    inputNumField.setAttribute('max', '699');
    inputNumField.setAttribute('aria-describedby', 'classroomNumHelp');
    inputNumField.classList.add('form-control');
    inputNumField.setAttribute('name', 'number');
    inputNumField.required = true;
    let labelNumField = document.createElement('label');
    labelNumField.textContent = 'Номер аудитории';
    labelNumField.classList.add('form-label');
    labelNumField.setAttribute('for', 'ClassroomNumFieldInput');
    let hintNumField = document.createElement('div');
    hintNumField.classList.add('form-text');
    hintNumField.setAttribute('id', 'classroomNumHelp');
    hintNumField.textContent = 'Поле обязательно к заполнению.';
    numField.append(labelNumField);
    numField.append(inputNumField);
    numField.append(hintNumField);
    form.append(numField);

    let capacityField = document.createElement('div');
    capacityField.classList.add('mb-3');
    let inputCapacityField = document.createElement('input');
    inputCapacityField.setAttribute('id', 'classroomCapacityFieldInput')
    inputCapacityField.setAttribute('type', 'number');
    inputCapacityField.setAttribute('min', '1');
    inputCapacityField.setAttribute('max', '200');
    inputCapacityField.setAttribute('aria-describedby', 'classroomCapacityHelp');
    inputCapacityField.classList.add('form-control');
    inputCapacityField.setAttribute('name', 'capacity');
    inputCapacityField.required = true;
    let labelCapacityField = document.createElement('label');
    labelCapacityField.textContent = 'Вместимость аудитории';
    labelCapacityField.classList.add('form-label');
    labelCapacityField.setAttribute('for', 'classroomCapacityFieldInput');
    let hintCapacityField = document.createElement('div');
    hintCapacityField.classList.add('form-text');
    hintCapacityField.setAttribute('id', 'classroomCapacityHelp');
    hintCapacityField.textContent = 'Это поле показывает максимально возможное количество сидячих мест в аудитории. Поле обязательно к заполнению.';
    capacityField.append(labelCapacityField);
    capacityField.append(inputCapacityField);
    capacityField.append(hintCapacityField);
    form.append(capacityField);

    const formGetButton = getAddButton('formСlassroomAddButton');
    form.append(formGetButton);

    return form;
}

function getCourseAddForm() {
    const form = document.createElement('form');

    const nameField = document.createElement('div');
    nameField.classList.add('mb-3');
    const inputNameField = document.createElement('input');
    inputNameField.setAttribute('id', 'CourseAddNameFieldInput');
    inputNameField.setAttribute('type', 'text');
    inputNameField.setAttribute('aria-describedby', 'courseNameHelp');
    inputNameField.setAttribute('name', 'name');
    inputNameField.setAttribute('required', null);
    inputNameField.classList.add('form-control');
    const labelNameField = document.createElement('label');
    labelNameField.classList.add('form-label');
    labelNameField.setAttribute('for', 'CourseAddNameFieldInput');
    labelNameField.textContent = 'Название курса';
    const hintNameField = document.createElement('div');
    hintNameField.classList.add('form-text')
    hintNameField.setAttribute('id', 'courseNameHelp');
    hintNameField.textContent = 'Введите название курса. Поле обязательно к заполнению.';
    nameField.append(labelNameField);
    nameField.append(inputNameField);
    nameField.append(hintNameField);
    form.append(nameField);

    const typeField = document.createElement('div');
    typeField.classList.add('mb-3');
    typeField.innerHTML = `
    <fieldset class="form-group">
        <legend style="font-size: 16px;">Охват курса</legend>
        <div class="form-check form-check-inline">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="type" id="optionsRadios1" value="stream" checked>
                Поток
            </label>
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="type" id="optionsRadios2" value="group">
                Группа
            </label>
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="type" id="optionsRadios3" value="special">
                Спецкурс
            </label>
        </div>
        <div class="form-text">
            Выберите тип курса в соответствии с тем, какой аудитории он предназначен. 
        </div>
    </fieldset>
    `;
    form.append(typeField);

    const numInPeriod = document.createElement('div');
    numInPeriod.classList.add('mb-3');
    numInPeriod.innerHTML = `
        <label for="CourseAddNumInPeriodFieldInput" class="form-label">Количество раз в неделю</label>
        <input type="number" min="1" max="7" class="form-control" id="CourseAddNumInPeriodFieldInput"
            name="times_per_week" aria-describedby="courseNumInPeriodHelp" required>
        <div id="courseNumInPeriodHelp" class="form-text">
            Введите количество занятий этого курса за одну неделю. Поле обязательно к заполнению.
        </div>
    `;
    form.append(numInPeriod);

    const courseAddYearField = document.createElement('div');
    courseAddYearField.classList.add('mb-3');
    courseAddYearField.innerHTML = `
        <label for="CourseAddYearFieldInput" class="form-label">Год проведения курса</label>
        <input type="number" min="1980" max="2100" class="form-control" id="CourseAddYearFieldInput" name="year" aria-describedby="courseYearHelp" required>
        <div id="courseYearHelp" class="form-text">
            Введите год, в котором проводится(или проводился) этот курс в формате YYYY. Поле обязательно к заполнению.
        </div>
    `;
    form.append(courseAddYearField);

    let studentsField = document.createElement('div');
    studentsField.classList.add('mb-3');
    let inputStudentsField = document.createElement('input');
    inputStudentsField.setAttribute('id', 'CoursesStudentsIdFieldInput');
    inputStudentsField.setAttribute('type', 'text');
    inputStudentsField.setAttribute('aria-describedby', 'coursesStudentsIdHelp');
    inputStudentsField.setAttribute('name', 'add_students_ids');
    inputStudentsField.classList.add('form-control');
    let labelStudentsField = document.createElement('label');
    labelStudentsField.classList.add('form-label');
    labelStudentsField.setAttribute('for', 'CoursesStudentsIdFieldInput');
    labelStudentsField.textContent = 'Id студентов курса';
    let hintStudentsField = document.createElement('div');
    hintStudentsField.classList.add('form-text')
    hintStudentsField.setAttribute('id', 'coursesStudentsIdHelp');
    hintStudentsField.textContent = 'Поле не обязательно к заполнению, при желании перечислите id студентов, которые слушают этот курс через запятую без пробелов';
    studentsField.append(labelStudentsField);
    studentsField.append(inputStudentsField);
    studentsField.append(hintStudentsField);
    form.append(studentsField);

    let profsField = document.createElement('div');
    profsField.classList.add('mb-3');
    let inputProfsField = document.createElement('input');
    inputProfsField.setAttribute('id', 'CoursesProfsIdFieldInput');
    inputProfsField.setAttribute('type', 'text');
    inputProfsField.setAttribute('aria-describedby', 'coursesProfsIdHelp');
    inputProfsField.setAttribute('name', 'add_professors_ids');
    inputProfsField.classList.add('form-control');
    let labelProfsField = document.createElement('label');
    labelProfsField.classList.add('form-label');
    labelProfsField.setAttribute('for', 'CoursesProfsIdFieldInput');
    labelProfsField.textContent = 'Id преподавателей курса';
    let hintProfsField = document.createElement('div');
    hintProfsField.classList.add('form-text')
    hintProfsField.setAttribute('id', 'coursesProfsIdHelp');
    hintProfsField.textContent = 'Поле не обязательно к заполнению, при желании перечислите id преподавателей, которые ведут этот курс через запятую без пробелов';
    profsField.append(labelProfsField);
    profsField.append(inputProfsField);
    profsField.append(hintProfsField);
    form.append(profsField);

    const formGetButton = getAddButton('formCourseAddButton');
    form.append(formGetButton);

    return form;
}

function getLessonAddForm() {
    const form = document.createElement('form');

    let courseIdField = document.createElement('div');
    courseIdField.classList.add('mb-3');
    let inputCourseIdField = document.createElement('input');
    inputCourseIdField.setAttribute('id', 'courseIdFieldInput')
    inputCourseIdField.setAttribute('type', 'number');
    inputCourseIdField.setAttribute('min', '1');
    inputCourseIdField.setAttribute('aria-describedby', 'courseIdHelp');
    inputCourseIdField.setAttribute('name', 'course_id');
    inputCourseIdField.classList.add('form-control');
    inputCourseIdField.required = true;
    let labelCourseIdField = document.createElement('label');
    labelCourseIdField.textContent = 'ID курса';
    labelCourseIdField.classList.add('form-label');
    labelCourseIdField.setAttribute('for', 'courseIdFieldInput');
    let hintCourseIdField = document.createElement('div');
    hintCourseIdField.classList.add('form-text');
    hintCourseIdField.setAttribute('id', 'courseIdHelp');
    hintCourseIdField.textContent = 'Введите id того курса, к которому хотите прикрепить занятие. Поле обязательно к заполнению.';
    courseIdField.append(labelCourseIdField);
    courseIdField.append(inputCourseIdField);
    courseIdField.append(hintCourseIdField);
    form.append(courseIdField);

    let numField = document.createElement('div');
    numField.classList.add('mb-3');
    let inputNumField = document.createElement('input');
    inputNumField.setAttribute('id', 'courseClassroomNumFieldInput')
    inputNumField.setAttribute('type', 'number');
    inputNumField.setAttribute('min', '100');
    inputNumField.setAttribute('max', '699');
    inputNumField.setAttribute('aria-describedby', 'courseClassroomNumHelp');
    inputNumField.setAttribute('name', 'classroom_number');
    inputNumField.classList.add('form-control');
    inputNumField.required = true;
    let labelNumField = document.createElement('label');
    labelNumField.textContent = 'Номер аудитории';
    labelNumField.classList.add('form-label');
    labelNumField.setAttribute('for', 'courseClassroomNumFieldInput');
    let hintNumField = document.createElement('div');
    hintNumField.classList.add('form-text');
    hintNumField.setAttribute('id', 'courseClassroomNumHelp');
    hintNumField.textContent = 'Поле обязательно к заполнению.';
    numField.append(labelNumField);
    numField.append(inputNumField);
    numField.append(hintNumField);
    form.append(numField);

    let startField = document.createElement('div');
    startField.classList.add('mb-3');
    let inputStartField = document.createElement('input');
    inputStartField.setAttribute('id', 'LessonStartFieldInput')
    inputStartField.setAttribute('type', 'datetime-local');
    inputStartField.setAttribute('aria-describedby', 'lessonStartHelp');
    inputStartField.setAttribute('name', 'start_time');
    inputStartField.setAttribute('required', null);
    inputStartField.classList.add('form-control');
    let labelStartField = document.createElement('label');
    labelStartField.classList.add('form-label');
    labelStartField.setAttribute('for', 'LessonStartFieldInput');
    labelStartField.textContent = 'Начало';
    let hintStartField = document.createElement('div');
    hintStartField.classList.add('form-text');
    hintStartField.setAttribute('id', 'lessonStartHelp');
    hintStartField.textContent = 'Введите время начала занятия. Поле обязательно к заполнению';
    startField.append(labelStartField);
    startField.append(inputStartField);
    startField.append(hintStartField);
    form.append(startField);


    const formGetButton = getAddButton('formLessonAddButton');
    form.append(formGetButton);

    return form;
}

function getObjectLessonsForm(name, label_name, form_id) {
    const form = document.createElement('form');
    form.innerHTML = `
    <div class="mb-3">
        <label for="idLessonsGet" class="form-label">ID ${label_name}</label>
        <input type="number" class="form-control" id="idLessonsGet" aria-describedby="idHelp" name="${name}">
        <div id="idHelp" class="form-text">Введите, пожалуйста, id ${label_name}. Поле является обязательным к заполнению</div>
    </div>
    `;

    const classroomForm = getClassroomForm();
    form.append(
        classroomForm.querySelector('#ClassroomsStartFieldInput').closest('div'),
        classroomForm.querySelector('#ClassroomsEndFieldInput').closest('div'),
    )

    let formGetButton = document.createElement('button');
    formGetButton.classList.add('btn');
    formGetButton.classList.add('btn-primary');
    formGetButton.setAttribute('type', 'submit');
    formGetButton.textContent = 'Получить';
    form.append(formGetButton);
    form.querySelector('#startHelp').textContent = 'Введите начало временного промежутка';
    form.querySelector('#endHelp').textContent = 'Введите конец временного промежутка';
    form.setAttribute('id', `${form_id}`);

    return form;
}

const getLoadErrorMsg = function () {
    const errorMsg = document.createElement('p');
    errorMsg.classList.add('load-error');
    errorMsg.textContent = 'Возникла ошибка связи с сервером. Попробуйте повторить действие или перезагрузите страницу.';

    return errorMsg;
};

async function getData (resource, container, params, forempty) {
    if (params.length !== 0) {
        resource += '?';
        for (let key of Object.keys(params)) {
            if (params[key]) {
                resource += `${key}=${params[key]}&`
            }
        }
        resource = resource.substring(0, resource.length - 1);
    }
    container.textContent = `Пожалуйста подождите. Данные загружаются с сервера...`;
    if (forempty) {
        forempty.textContent = '';
    }
    const response = await fetch(resource);
    if (response.status !== 200) {
        container.textContent = ``;
        const errorMsg = getLoadErrorMsg();
        container.append(errorMsg);
        return;
    }
    return await response.json();
}

function getCourseCard(elem) {
    const type_object = {'group': 'Для группы', 'stream': 'Поточный', 'special': 'Спецкурс'};
    const card = document.createElement('div');
    card.classList.add('card');
    card.style = 'width: 400px';
    card.innerHTML = `
        <div class="card-body">
            <div style="display: flex; justify-content: center">
                <h5 class="card-title" name-holder>Курс ${elem['name']}</h5>
            </div>
            <p class="card-text" id-holder course-id>ID: ${elem['id']}</p>
            <p class="card-text" year-holder>Год проведения: ${elem['year']}</p>
            <p class="card-text" type-holder>Тип курса: ${type_object[elem['type']]}</p>
            <p class="card-text" times-week-holder>Количество раз в неделю: ${elem['times_per_week']}</p>
            <p class="card-text" profs>Преподаватели:</p>
        </div>
        <div class="card-footer" style="display: flex; justify-content: flex-end">
            <button class="btn btn-sm btn-primary" button-editor>Редактировать</button>
            <button class="btn btn-sm btn-dark" button-deleter>Удалить</a>
        </div>
    `;
    const profs = card.querySelector('p[profs]');
    if (elem['professors_full_names'].length === 0) {
        profs.textContent += ' преподаватели пока не назначены'
    }
    elem['professors_full_names'].forEach((elem) => {
       const newProf = document.createElement('p');
       newProf.classList.add('card-text');
       newProf.textContent = elem;
       profs.after(newProf);
    });

    return card;
}

function getStudentCard(elem) {
    const card = document.createElement('div');
    card.classList.add('card');
    card.style = 'width: 400px';
    card.innerHTML = `
        <div class="card-body">
            <div style="display: flex; justify-content: center">
                <h5 class="card-title">Студент</h5>
            </div>
            <p class="card-text" name-holder>Имя: ${elem['name']}</p>
            <p class="card-text" surname-holder>Фамилия: ${elem['surname']}</p>
            <p class="card-text" patronymic-holder>Отчество: ${elem['patronymic']}</p>
            <p class="card-text" stream-holder>Поток: ${elem['stream']}</p>
            <p class="card-text" group-holder>Группа: ${elem['group']}</p>
            <p class="card-text" year-holder>Год обучения: ${elem['year']}</p>
            <p class="card-text" id-holder student-id>ID: ${elem['id']}</p>
        </div>
        <div class="card-footer" style="display: flex; justify-content: flex-end">
            <button class="btn btn-sm btn-primary" button-editor>Редактировать</button>
            <button class="btn btn-sm btn-dark" button-deleter>Удалить</a>
        </div>
    `;

    return card;
}

function getProfCard(elem) {
    const card = document.createElement('div');
    card.classList.add('card');
    card.style = 'width: 400px';
    card.innerHTML = `
        <div class="card-body">
            <div style="display: flex; justify-content: center">
                <h5 class="card-title">Преподаватель</h5>
            </div>
            <p class="card-text" name-holder>Имя: ${elem['name']}</p>
            <p class="card-text" surname-holder>Фамилия: ${elem['surname']}</p>
            <p class="card-text" patronymic-holder>Отчество: ${elem['patronymic']}</p>
            <p class="card-text" id-holder prof-id>ID: ${elem['id']}</p>
        </div>
        <div class="card-footer" style="display: flex; justify-content: flex-end">
            <button class="btn btn-sm btn-primary" button-editor>Редактировать</button>
            <button class="btn btn-sm btn-dark" button-deleter>Удалить</a>
        </div>
    `;

    return card;
}

function displayCard(card, index) {
    const container = document.querySelector('div.container-md');
    if (container.querySelector('.greetings') || index === 0) {
        container.innerHTML = '';
    }
    if (index % 3 === 0) {
        const newRow = document.createElement('div');
        newRow.classList.add('row');
        newRow.innerHTML = `
            <div class="col-md d-flex align-items-stretch">
            </div>
            <div class="col-md d-flex align-items-stretch">
            </div>
            <div class="col-md d-flex align-items-stretch">
            </div>
        `;
        container.append(newRow);
    }

    const lastRow = container.querySelector('div.container-md > div.row:last-child');
    const cardColumn = lastRow.querySelector(`div.col-md:nth-child(${index % 3 + 1})`);
    cardColumn.append(card);
}

function displayClassroom(classroom, index, object) {
    const container = document.querySelector('div.container-md');
    container.innerHTML = (container.querySelector('.greetings') || index === 0) ? '' : container.innerHTML;
    if (index === 0) {
        const startTime = `
            ${object['startTime'].substring(8, 10)}.${object['startTime'].substring(5, 7)}.${object['startTime'].substring(0, 4)} ${object['startTime'].substring(11, 16)}
        `;
        const endTime = `
            ${object['endTime'].substring(8, 10)}.${object['endTime'].substring(5, 7)}.${object['endTime'].substring(0, 4)} ${object['endTime'].substring(11, 16)}
        `;
        container.innerHTML = `
            <div class="d-flex justify-content-center" style="font-size: 42px">Доступные аудитории</div>
            <div class="d-flex justify-content-center" style="font-size: 32px">Время ${startTime} - ${endTime}</div>
        `;
    }
    container.innerHTML += `
        <p>Номер: ${classroom['number']} — Вместимость: ${classroom['capacity']}</p>
    `;
}

function displayLessons(lesson, index) {
    const container = document.querySelector('div.container-md');
    container.innerHTML = (container.querySelector('.greetings') || index === 0) ? '' : container.innerHTML;
    if (index === 0) {
        container.innerHTML = `
            <div class="d-flex justify-content-center" style="font-size: 42px">Расписание</div>
        `;
    }
    lesson['classroom_number'] = (lesson['classroom_number']) ? lesson['classroom_number'] : 'Аудитория не назначена';
    const value = lesson['start_time'];
    lesson['start_time'] = `${value.substring(8, 10)}.${value.substring(5, 7)}.${value.substring(0, 4)} ${value.substring(11, 16)}`;
    container.innerHTML += `
        <p>${lesson['course_name']} — ${lesson['classroom_number']} — ${lesson['start_time']}</p>
    `;
}

function getLessonsResource(node, object) {
    let resource = 'http://localhost:8080/lessons/'
    if (node.matches('form#FormToGetStudentSchedule')) {
        resource += `students/get/${object['student_id']}`;
    }
    else if (node.matches('form#FormToGetProfSchedule')){
        resource += `professors/get/${object['professor_id']}`;
    }
    else {
        resource += `classrooms/get/${object['classroom_id']}`;
    }

    return resource
}

async function postData (object, url, container, forempty) {
    container.textContent = `Пожалуйста подождите. Связываемся с сервером...`;
    if (forempty) {
        forempty.textContent = '';
    }
    const json = JSON.stringify(object);
    const response = await fetch(url, {
        method: 'POST',
        body: json,
        headers: {
            'Content-Type': 'application/json',
        }
    });
    if (response.status === 200) {
        return 1;
    }
    return 0;
}

function getDeleteResource(node) {
    const idHolder = node.querySelector('p[id-holder]');
    let resource = 'http://localhost:8080/';
    const id = idHolder.textContent.substring(4, idHolder.textContent.length);
    if (idHolder.hasAttribute('student-id')) {
        resource += `students/delete/${id}`;
    } else if (idHolder.hasAttribute('prof-id')) {
        resource += `professors/delete/${id}`;
    } else if (idHolder.hasAttribute('course-id')) {
        resource += `courses/delete/${id}`;
    }

    return resource
}

function redisplayCards() {
    const cards = document.querySelectorAll('div.card');
    cards.forEach((card, index) => displayCard(card, index));
}

function getTitleEditText(node) {
    const idHolder = node.querySelector('p[id-holder]');
    if (idHolder.hasAttribute('student-id')) {
        return 'Редактирование студента';
    } else if (idHolder.hasAttribute('prof-id')) {
        return 'Редактирование преподавателя';
    } else if (idHolder.hasAttribute('course-id')) {
        return 'Редактирование курса';
    }
}

function getEditForm(node) {
    const idHolder = node.querySelector('p[id-holder]');
    const id = idHolder.textContent.substring(4, idHolder.textContent.length);
    if (idHolder.hasAttribute('student-id')) {
        return getStudentEditForm(node, id);
    } else if (idHolder.hasAttribute('prof-id')) {
        return getProfessorEditForm(node, id);
    } else if (idHolder.hasAttribute('course-id')) {
        return getCourseEditForm(node, id);
    }
}

function getStudentEditForm(node, id) {
    const student_name_info = node.querySelector('p[name-holder]').textContent;
    const student_name = student_name_info.substring(5, student_name_info.length);

    const student_surname_info = node.querySelector('p[surname-holder]').textContent;
    const student_surname = student_surname_info.substring(9, student_surname_info.length);

    const student_patronymic_info = node.querySelector('p[patronymic-holder]').textContent;
    const student_patronymic = student_patronymic_info.substring(10, student_patronymic_info.length);

    const student_stream_info = node.querySelector('p[stream-holder]').textContent;
    const student_stream = student_stream_info.substring(7, student_stream_info.length);

    const student_group_info = node.querySelector('p[group-holder]').textContent;
    const student_group = student_group_info.substring(8, student_group_info.length);

    const student_year_info = node.querySelector('p[year-holder]').textContent;
    const student_year = student_year_info.substring(14, student_year_info.length);

    const values = [student_name, student_surname, student_patronymic, student_group, student_stream, student_year];

    const form = getStudentAddForm();
    const inputs = form.querySelectorAll('input');
    inputs.forEach((elem, index) => {elem.setAttribute('value', values[index])});
    form.querySelector('button').removeAttribute('id');
    form.querySelector('button').textContent = 'Редактировать';
    form.setAttribute('id', 'FormToEditStudent');

    form.append(getHiddenInput(id));
    return form;
}

function getProfessorEditForm(node, id) {
    const prof_name_info = node.querySelector('p[name-holder]').textContent;
    const prof_name = prof_name_info.substring(5, prof_name_info.length);

    const prof_surname_info = node.querySelector('p[surname-holder]').textContent;
    const prof_surname = prof_surname_info.substring(9, prof_surname_info.length);

    const prof_patronymic_info = node.querySelector('p[patronymic-holder]').textContent;
    const prof_patronymic = prof_patronymic_info.substring(10, prof_patronymic_info.length);

    const values = [prof_name, prof_surname, prof_patronymic];

    const form = getProfessorsForm(true);
    const inputs = form.querySelectorAll('input');
    inputs.forEach((elem, index) => {elem.setAttribute('value', values[index])});
    form.querySelector('button').removeAttribute('id');
    form.querySelector('button').textContent = 'Редактировать';
    form.setAttribute('id', 'FormToEditProf');

    form.append(getHiddenInput(id));

    return form;
}

function getCourseEditForm(node, id) {
    const course_name_info = node.querySelector('h5[name-holder]').textContent;
    const course_name = course_name_info.substring(5, course_name_info.length);

    const course_type_info = node.querySelector('p[type-holder]').textContent;
    let course_type = course_type_info.substring(11, course_type_info.length);
    course_type = (course_type === 'Для группы') ? 'group' :
        (course_type === 'Поточный') ? 'stream' : 'special';

    const course_times_info = node.querySelector('p[times-week-holder]').textContent;
    const course_times = course_times_info.substring(25, course_times_info.length);

    const course_year_info = node.querySelector('p[year-holder]').textContent;
    const course_year = course_year_info.substring(16, course_year_info.length);

    const form = getCourseAddForm();
    form.querySelector('input#CourseAddNameFieldInput').setAttribute('value', course_name);
    form.querySelector('input[value="stream"]').removeAttribute('checked');
    form.querySelector(`input[value=${course_type}]`).setAttribute('checked', '');
    form.querySelector('input#CourseAddNumInPeriodFieldInput').setAttribute('value', course_times);
    form.querySelector('input#CourseAddYearFieldInput').setAttribute('value', course_year)
    form.querySelector('button').removeAttribute('id');
    form.querySelector('button').textContent = 'Редактировать';

    form.querySelector('label[for=CoursesProfsIdFieldInput]').textContent = 'ID преподавателей, которых вы хотите добавить на курс';
    form.querySelector('div#coursesProfsIdHelp').textContent = `
        Поле не обязательно, при желании перечислите через запятую без пробелов id преподавателей, которых хотите добавить вести курс.
    `;

    form.querySelector('label[for=CoursesStudentsIdFieldInput]').textContent = 'ID студентов, которых вы хотите записать на курс';
    form.querySelector('div#coursesStudentsIdHelp').textContent = `
        Поле не обязательно, при желании перечислите через запятую без пробелов id студентов, которых вы хотите записать на курс.
    `;

    const del_student = document.createElement('div');
    del_student.classList.add('mb-3');
    del_student.innerHTML = `
        <label for="CourseDeleteStudent" class="form-label">ID студентов, которых вы хотите убрать с курса</label>
        <input type="text" class="form-control" id="CourseDeleteStudent"
            name="delete_students_ids" aria-describedby="courseDeleteStudentHelp">
        <div id="courseDeleteStudentHelp" class="form-text">
            Поле не обязательно, при желании перечислите через запятую без пробелов id студентов, которых хотите удалить с курса.
        </div>
    `;

    const del_profs = document.createElement('div');
    del_profs.classList.add('mb-3');
    del_profs.innerHTML = `
        <label for="CourseDeleteProfs" class="form-label">ID преподавателей, которых вы хотите убрать с курса</label>
        <input type="text" class="form-control" id="CourseAddNumInPeriodFieldInput"
            name="delete_professors_ids" aria-describedby="courseDeleteProfsHelp">
        <div id="courseDeleteProfsHelp" class="form-text">
            Поле не обязательно, при желании перечислите через запятую без пробелов id преподавателей, которых хотите убрать с курса.
        </div>
    `;

    form.querySelector('#CoursesProfsIdFieldInput').closest('div').after(
        del_student, del_profs
    );

    form.append(getHiddenInput(id));
    form.setAttribute('id', 'FormToEditCourse');

    return form;
}

function getHiddenInput(id) {
    const input = document.createElement('input');
    input.setAttribute('type', 'hidden');
    input.setAttribute('name', 'id-holder');
    input.setAttribute('value', id);

    return input;
}
