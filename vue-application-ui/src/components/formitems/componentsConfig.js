export const basicComponents = [
  {
    type: 'Text',
    icon: 'icon-input',
    options: {
      width: '100%',
      defaultValue: '',
      required: false,
      dataType: 'string',
      pattern: '',
      placeholder: '' ,
      disabled: false,
      label: '' ,
      description:''
    },
  },
  {
    type: 'Textarea',
    icon: 'icon-diy-com-textarea',
    options: {
      width: '100%',
      defaultValue: '',
      required: false,
      disabled: false,
      pattern: '',
      placeholder: '',
      label: '',
      description:'' 
    },
  },
  // {
  //   type: 'Number',
  //   icon: 'icon-number',
  //   options: {
  //     width: '',
  //     required: false,
  //     defaultValue: 0,
  //     min: '',
  //     max: '',
  //     step: 1,
  //     disabled: false,
  //     controlsPosition: '',
  //   },
  // },
  // {
  //   type: 'Email',
  //   icon: 'icon-color',
  //   options: {
  //     defaultValue: '',
  //     disabled: false,
  //     showAlpha: false,
  //     required: false,
  //     placeholder: ''
  //   },
  // },
  {
    type: 'Radio',
    icon: 'icon-radio-active',
    options: {
      label:'',
      description:'',
      inline: false,
      defaultValue: '',
      showLabel: false,
      options: [
        {
          value: '',
          label: 'Option 1',
        },
        {
          value: '',
          label: 'Option 2',
        },
        {
          value: '',
          label: 'Option 3',
        },
      ],
      required: false,
      width: '',
      name:'',
      remote: false,
      remoteOptions: [],
      props: {
        value: 'value',
        label: 'label',
      },
      remoteFunc: '',
      disabled: false,
    },
  },
  {
    type: 'Checkbox',
    icon: 'icon-check-box',
    options: {
      inline: false,
      defaultValue: [],
      showLabel: false,
      options: [
        {
          value: '',
          label: 'Option 1',
        },
        {
          value: '',
          label: 'Option 2',
        },
        {
          value: '',
          label: 'Option 3',
        },
      ],
      required: false,
      width: '',
      remote: false,
      remoteOptions: [],
      props: {
        value: 'value',
        label: 'label',
      },
      remoteFunc: '',
      disabled: false,
    },
  },
  {
    type: 'Select',
    icon: 'icon-select',
    options: {
      defaultValue: '',
      multiple: false,
      disabled: false,
      clearable: false,
      placeholder: '',
      required: false,
      showLabel: false,
      width: '',
      options: [
        {
          value: 'Option 1',
        },
        {
          value: 'Option 2',
        },
        {
          value: 'Option 3',
        },
      ],
      remote: false,
      filterable: false,
      remoteOptions: [],
      props: {
        value: 'value',
        label: 'label',
      },
      remoteFunc: '',
    },
  },
  {
    type: 'Toggle',
    icon: 'icon-switch',
    options: {
      label:'Toggle here',
      value: false,
      required: false,
      disabled: false,
    },
  },
  {
    type: 'Time',
    icon: 'icon-time',
    options: {
      defaultValue: '21:19:56',
      readonly: false,
      disabled: false,
      editable: true,
      clearable: true,
      placeholder: '',
      startPlaceholder: '',
      endPlaceholder: '',
      isRange: false,
      arrowControl: true,
      format: 'HH:mm:ss',
      required: false,
      width: '',
    },
  },
  {
    type: 'Date',
    icon: 'icon-date',
    options: {
      defaultValue: '',
      readonly: false,
      disabled: false,
      editable: true,
      clearable: true,
      placeholder: '',
      startPlaceholder: '',
      endPlaceholder: '',
      type: 'date',
      format: 'yyyy-MM-dd',
      timestamp: false,
      required: false,
      width: '',
    },
  },
  {
    type: 'DateTime',
    icon: 'icon-pingfen1',
    options: {
      defaultValue: null,
      max: 5,
      disabled: false,
      allowHalf: false,
      required: false,
    },
  },
  
  {
    type: 'Slider',
    icon: 'icon-slider',
    options: {
      defaultValue: 0,
      disabled: false,
      required: false,
      min: 0,
      max: 100,
      step: 1,
      showInput: false,
      range: false,
      width: '',
    },
  },
  {
    type: 'FileUpload',
    icon: 'icon-wenzishezhi-',
    options: {
      label: 'Upload file',
      descriptionf: 'SVG, PNG, JPG or GIF (MAX. 800x400px).',
      defaultValue: 'This is a text',
      customClass: '',
    },
  },
  {
    type: 'Signature',
    icon: 'icon-wenzishezhi-',
    options: {
      defaultValue: 'This is a text',
      customClass: '',
    },
  },
];

export const advanceComponents = [
  {
    type: 'blank',
    icon: 'icon-zidingyishuju',
    options: {
      defaultType: 'String',
    },
  },
  {
    type: 'imgupload',
    icon: 'icon-tupian',
    options: {
      defaultValue: [],
      size: {
        width: 100,
        height: 100,
      },
      width: '',
      tokenFunc: 'funcGetToken',
      token: '',
      domain: 'http://pfp81ptt6.bkt.clouddn.com/',
      disabled: false,
      length: 8,
      multiple: false,
      isQiniu: false,
      isDelete: false,
      min: 0,
      isEdit: false,
      action: 'https://jsonplaceholder.typicode.com/photos/',
    },
  },
  {
    type: 'editor',
    icon: 'icon-fuwenbenkuang',
    options: {
      defaultValue: '',
      width: '',
    },
  },
  {
    type: 'cascader',
    icon: 'icon-jilianxuanze',
    options: {
      defaultValue: [],
      width: '',
      placeholder: '',
      disabled: false,
      clearable: false,
      remote: true,
      remoteOptions: [],
      props: {
        value: 'value',
        label: 'label',
        children: 'children',
      },
      remoteFunc: '',
    },
  },
  {
    type: 'table',
    icon: 'icon-table',
    options: {
      stripe: true,
      border: false,
      height: '400',
      columns: [
        {
          field: 'date',
          label: '日期',
          width: '180',
        },
        {
          field: 'name',
          label: '姓名',
          width: '180',
        },
        {
          field: 'address',
          label: '地址',
        },
      ],
      defaultValue: [
        {
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
        },
        {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄',
        },
      ],
    },
  },
];

export const layoutComponents = [
  {
    type: 'grid',
    icon: 'icon-grid-',
    columns: [
      {
        span: 12,
        list: [],
      },
      {
        span: 12,
        list: [],
      },
    ],
    options: {
      gutter: 0,
      justify: 'start',
      align: 'top',
    },
  },
];
